package com.bozdag.learning.auditing.temporal;

import com.bozdag.learning.auditing.temporal.domain.Customer;
import com.bozdag.learning.auditing.temporal.repository.CustomerRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DateAuditSampleApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(DateAuditSampleApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DateAuditSampleApplication.class, args);
  }

  @Bean
  public CommandLineRunner sampleRunner(CustomerRepository repository) {

    return (args) -> {
      repository.save( new Customer("Frodo", "Baggins", "Shire"));
      repository.save( new Customer("Samwise", "Gamgee", "Shire"));

      // List customers
      for (Customer customer: repository.findAll()) {
        LOGGER.info(customer.toString());
      }

      // Get the first customer
      // and update
      Customer firstCustomer = repository.findById(1L);
      firstCustomer.setCountry("Mordor");
      Customer updatedCustomer = repository.save(firstCustomer);

      LOGGER.info("Updated Customer");
      LOGGER.info("----------------");
      LOGGER.info(updatedCustomer.toString());

    };
  }


}
