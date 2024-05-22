package id.my.hendisantika.paymentms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Getter
@Setter
@ToString
public class PaymentEvent {

    private String type;

    private CustomerOrder order;
}
