package id.my.hendisantika.paymentms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.paymentms.dto.CustomerOrder;
import id.my.hendisantika.paymentms.dto.OrderEvent;
import id.my.hendisantika.paymentms.dto.PaymentEvent;
import id.my.hendisantika.paymentms.entity.Payment;
import id.my.hendisantika.paymentms.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:58
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ReversePayment {

    private final PaymentRepository paymentRepository;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @KafkaListener(topics = "reversed-payments", groupId = "payments-group")
    public void reversePayment(String event) {
        log.info("Inside reverse payment for order {}", event);

        try {
            PaymentEvent paymentEvent = new ObjectMapper().readValue(event, PaymentEvent.class);

            CustomerOrder order = paymentEvent.getOrder();

            Iterable<Payment> payments = this.paymentRepository.findByOrderId(order.getOrderId());

            payments.forEach(p -> {
                p.setStatus("FAILED");
                paymentRepository.save(p);
            });

            OrderEvent orderEvent = new OrderEvent();
            orderEvent.setOrder(paymentEvent.getOrder());
            orderEvent.setType("ORDER_REVERSED");
            kafkaTemplate.send("reversed-orders", orderEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
