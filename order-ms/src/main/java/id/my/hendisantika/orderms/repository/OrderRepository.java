package id.my.hendisantika.orderms.repository;

import id.my.hendisantika.orderms.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:42
 * To change this template use File | Settings | File Templates.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
