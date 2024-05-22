package id.my.hendisantika.paymentms.controller;

import id.my.hendisantika.paymentms.dto.OrderEvent;
import id.my.hendisantika.paymentms.dto.PaymentEvent;
import id.my.hendisantika.paymentms.entity.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
