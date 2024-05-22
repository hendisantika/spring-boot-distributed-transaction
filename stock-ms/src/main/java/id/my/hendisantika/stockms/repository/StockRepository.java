package id.my.hendisantika.stockms.repository;

import id.my.hendisantika.stockms.entity.WareHouse;
import org.springframework.data.repository.CrudRepository;

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
public interface StockRepository extends CrudRepository<WareHouse, Long> {

    Iterable<WareHouse> findByItem(String item);
}
