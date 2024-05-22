package id.my.hendisantika.stockms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-distributed-transaction
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/23/24
 * Time: 05:32
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Getter
@Setter
public class WareHouse {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private int quantity;

    @Column
    private String item;
}
