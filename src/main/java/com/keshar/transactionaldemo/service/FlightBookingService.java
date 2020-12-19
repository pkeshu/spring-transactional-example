package com.keshar.transactionaldemo.service;

import com.keshar.transactionaldemo.entiry.PassengerInfo;
import com.keshar.transactionaldemo.entiry.PaymentInfo;
import com.keshar.transactionaldemo.exception.InvalidAmountException;
import com.keshar.transactionaldemo.model.FlightAcknowledgementDto;
import com.keshar.transactionaldemo.model.FlightBookingRequestDto;
import com.keshar.transactionaldemo.repository.PassengerInfoRepository;
import com.keshar.transactionaldemo.repository.PaymentInfoRepository;
import com.keshar.transactionaldemo.util.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightAcknowledgementDto bookFlightTicket(FlightBookingRequestDto flightBookingRequestDto) {
        PassengerInfo passengerInfo = flightBookingRequestDto.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo = flightBookingRequestDto.getPaymentInfo();
        PaymentUtil.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo = paymentInfoRepository.save(paymentInfo);
        return new FlightAcknowledgementDto("SUCCESS", paymentInfo.getAmount(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
