package com.keshar.transactionaldemo;

import com.keshar.transactionaldemo.exception.InvalidAmountException;
import com.keshar.transactionaldemo.model.FlightAcknowledgementDto;
import com.keshar.transactionaldemo.model.FlightBookingRequestDto;
import com.keshar.transactionaldemo.service.FlightBookingService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionalDemoApplication {
    @Autowired
    private FlightBookingService service;

    @PostMapping("/bookFlight")
    public FlightAcknowledgementDto bookFlight(@RequestBody FlightBookingRequestDto flightBookingRequestDto) throws InvalidAmountException {
        return service.bookFlightTicket(flightBookingRequestDto);
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemoApplication.class, args);
    }

}
