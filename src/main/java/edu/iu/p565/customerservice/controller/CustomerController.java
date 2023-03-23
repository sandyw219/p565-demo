package edu.iu.p565.customerservice.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customers") // any request that has link /customers will be handled here
public class CustomerController {
    private CustomerRepository repository; // this is a dependency injection from spring, we don't need to initialize ourselves

    public CustomerController(CustomerRepository repository) { // tell spring to inject it
        this.repository = repository;
    }

    
    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @PostMapping()
    public int create(@Valid @RequestBody Customer customer) { // customer data comes from user
        // @requestbody in above line tells it that the data is in the body of the request
        return repository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id) {
        repository.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.delete(id);
    }

}
