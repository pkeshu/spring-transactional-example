package com.keshar.transactionaldemo.repository;

import com.keshar.transactionaldemo.entiry.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
