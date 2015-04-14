package hello.model;

import hello.model.generic.GenericCustomer;
import org.springframework.data.mongodb.core.index.Indexed;

public class Customer extends GenericCustomer<Customer> {
    public Customer(Long id, String firstName, String lastName, Customer referrer) {
        super(id, firstName, lastName, referrer);
    }
}
