package id.my.hendisantika.deliveryms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.deliveryms.dto.CustomerOrder;
import id.my.hendisantika.deliveryms.dto.DeliveryEvent;
import id.my.hendisantika.deliveryms.entity.Delivery;
import id.my.hendisantika.deliveryms.repository.DeliveryRepository;
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
 * Time: 06:44
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    @KafkaListener(topics = "new-stock", groupId = "stock-group")
    public void deliverOrder(String event) throws JsonProcessingException {
        log.info("Inside ship order for order {}", event);

        Delivery shipment = new Delivery();
        DeliveryEvent inventoryEvent = new ObjectMapper().readValue(event, DeliveryEvent.class);
        CustomerOrder order = inventoryEvent.getOrder();

        try {
            if (order.getAddress() == null) {
                throw new Exception("Address not present");
            }

            shipment.setAddress(order.getAddress());
            shipment.setOrderId(order.getOrderId());

            shipment.setStatus("SUCCESS");

            deliveryRepository.save(shipment);
            log.info("SHIPMENT_SUCCESS {}", shipment);
        } catch (Exception e) {
            shipment.setOrderId(order.getOrderId());
            shipment.setStatus("failed");
            deliveryRepository.save(shipment);

            log.info("STOCK_REVERSED {}", order);

            DeliveryEvent reverseEvent = new DeliveryEvent();
            reverseEvent.setType("STOCK_REVERSED");
            reverseEvent.setOrder(order);
            kafkaTemplate.send("reversed-stock", reverseEvent);
        }
    }
}
