package id.my.hendisantika.stockms.controller;

import id.my.hendisantika.stockms.dto.DeliveryEvent;
import id.my.hendisantika.stockms.dto.PaymentEvent;
import id.my.hendisantika.stockms.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 * Time: 05:38
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StockController {

    private final StockRepository stockRepository;

    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    private final KafkaTemplate<String, PaymentEvent> kafkaPaymentTemplate;
}
