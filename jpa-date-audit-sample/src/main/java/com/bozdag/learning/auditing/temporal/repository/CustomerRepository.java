package com.bozdag.learning.auditing.temporal.repository;

import com.bozdag.learning.auditing.temporal.domain.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}
