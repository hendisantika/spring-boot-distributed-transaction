package id.my.hendisantika.paymentms.service;

import id.my.hendisantika.paymentms.dto.OrderEvent;
import id.my.hendisantika.paymentms.entity.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
