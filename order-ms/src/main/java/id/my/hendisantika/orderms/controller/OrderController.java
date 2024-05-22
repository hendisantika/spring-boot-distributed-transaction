package id.my.hendisantika.orderms.controller;

import id.my.hendisantika.orderms.dto.OrderEvent;
import id.my.hendisantika.orderms.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:45
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

}
