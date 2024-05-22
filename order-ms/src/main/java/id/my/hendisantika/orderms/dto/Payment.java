package id.my.hendisantika.orderms.dto;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class Payment {

    private String mode;

    private Long orderId;

    private double amount;
}
