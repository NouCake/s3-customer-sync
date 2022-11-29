package de.kevfischer.s3customersync;

import de.kevfischer.s3customersync.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
