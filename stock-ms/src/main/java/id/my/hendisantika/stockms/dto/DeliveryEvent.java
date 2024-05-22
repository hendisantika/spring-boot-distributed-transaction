package id.my.hendisantika.stockms.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:33
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class DeliveryEvent {

    private String type;

    private CustomerOrder order;
}
