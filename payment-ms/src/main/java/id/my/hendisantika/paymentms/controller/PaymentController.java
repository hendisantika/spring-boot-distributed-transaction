package id.my.hendisantika.paymentms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 06:00
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository paymentRepository;

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    private final KafkaTemplate<String, OrderEvent> kafkaOrderTemplate;

    @KafkaListener(topics = "new-orders", groupId = "orders-group")
    public void processPayment(String event) throws JsonProcessingException {
        log.info("Received event for payment {}", event);
        OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);

        CustomerOrder order = orderEvent.getOrder();
        Payment payment = new Payment();

        try {
            payment.setAmount(order.getAmount());
            payment.setMode(order.getPaymentMode());
            payment.setOrderId(order.getOrderId());
            payment.setStatus("SUCCESS");
            paymentRepository.save(payment);
            log.info("PAYMENT_SUCCESS {}", payment);

            PaymentEvent paymentEvent = new PaymentEvent();
            paymentEvent.setOrder(orderEvent.getOrder());
            paymentEvent.setType("PAYMENT_CREATED");
            kafkaTemplate.send("new-payments", paymentEvent);
            log.info("PAYMENT_CREATED {}", paymentEvent);
        } catch (Exception e) {
            payment.setOrderId(order.getOrderId());
            payment.setStatus("FAILED");
            paymentRepository.save(payment);
            log.info("PAYMENT_FAILED {}", payment);

            OrderEvent oe = new OrderEvent();
            oe.setOrder(order);
            oe.setType("ORDER_REVERSED");
            kafkaOrderTemplate.send("reversed-orders", orderEvent);
            log.info("ORDER_REVERSED {}", oe);
        }
    }

}
