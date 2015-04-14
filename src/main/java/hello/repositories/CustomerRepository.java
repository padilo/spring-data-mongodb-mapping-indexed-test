package hello.repositories;

import hello.model.Customer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
    Customer findByFirstName(String firstName);
}
