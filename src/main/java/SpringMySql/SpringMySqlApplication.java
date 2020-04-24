package SpringMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("SpringMySql.repository")
public class SpringMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMySqlApplication.class, args);
	}

}
