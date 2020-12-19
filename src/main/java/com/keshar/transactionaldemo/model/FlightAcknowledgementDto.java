package com.keshar.transactionaldemo.model;

import com.keshar.transactionaldemo.entiry.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightAcknowledgementDto {
    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
