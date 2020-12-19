package com.keshar.transactionaldemo.model;

import com.keshar.transactionaldemo.entiry.PassengerInfo;
import com.keshar.transactionaldemo.entiry.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequestDto {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
