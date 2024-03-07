package ecommerce.sprinboot.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"bd.edu.diu.cis.customer", "bd.edu.diu.cis.library"})
@EnableJpaRepositories(value = "bd.edu.diu.cis.library.repository")
@EntityScan(value = "bd.edu.diu.cis.library.model")
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
