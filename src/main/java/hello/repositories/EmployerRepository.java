package hello.repositories;

import hello.model.Customer;
import hello.model.Employer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployerRepository extends MongoRepository<Employer, Long> {
    Customer findByFirstName(String firstName);
}
