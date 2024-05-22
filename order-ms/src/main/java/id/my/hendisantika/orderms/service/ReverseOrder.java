package id.my.hendisantika.orderms.service;

import id.my.hendisantika.orderms.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:44
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ReverseOrder {

    private final OrderRepository orderRepository;
}
