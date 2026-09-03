package org.example.order_management.infrastructure.mongodb.repository;


import org.example.order_management.domain.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPaymentRepository extends MongoRepository<Payment, String> {
}

