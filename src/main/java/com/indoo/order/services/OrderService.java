package com.indoo.order.services;

import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "purchase-initiation-topic", groupId = "order-service-group")
    public void OrderListener(String order) {
        System.out.println("Order Received: " + order);
        publishOrder(order);
    }

    public void publishOrder(String order) {
        kafkaTemplate.send("order-created-topic", order);
    }
}
