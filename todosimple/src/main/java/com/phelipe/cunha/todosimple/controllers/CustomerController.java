package com.phelipe.cunha.todosimple.controllers;
import com.phelipe.cunha.todosimple.models.Customer;
import com.phelipe.cunha.todosimple.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id){
		Customer customer = this.customerService.findById(id);
		return  ResponseEntity.ok().body(customer);
	}

	@GetMapping
	public  ResponseEntity<List<Customer>> findAll(){return ResponseEntity.ok().body(customerService.findAll());
	}

	@PostMapping
	@Validated(Customer.CreateCustomer.class)
	public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer){
		this.customerService.create(customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(uri).body(customer);
	}

	@PutMapping("/{id}")
	@Validated(Customer.UpdateCustomer.class)
	ResponseEntity<Customer> update(@Valid @RequestBody Customer customer, @PathVariable Long id){
		customer.setId(id);
		this.customerService.update(customer);
		return ResponseEntity.ok().body(customer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		this.customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
