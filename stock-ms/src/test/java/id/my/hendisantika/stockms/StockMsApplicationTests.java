package id.my.hendisantika.stockms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.kafka.bootstrap-servers=localhost:9092",
        "spring.kafka.properties.security.protocol=PLAINTEXT",
        "spring.kafka.listener.auto-startup=false"
})
class StockMsApplicationTests {

	@Test
	void contextLoads() {
	}

}
