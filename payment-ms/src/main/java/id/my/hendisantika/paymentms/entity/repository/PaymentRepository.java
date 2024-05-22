package id.my.hendisantika.paymentms.entity.repository;

import id.my.hendisantika.paymentms.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:57
 * To change this template use File | Settings | File Templates.
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findByOrderId(long orderId);
}
