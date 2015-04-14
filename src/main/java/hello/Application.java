package hello;

import hello.model.Customer;
import hello.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Arrays;
import java.util.Collections;

@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers

        Customer c1 = new Customer(1L, "Alice", "Smith", null);
        Customer c2 = new Customer(2L, "Bob", "Smith", c1);

        repository.save(c1);
        repository.save(c2);


    }

}
