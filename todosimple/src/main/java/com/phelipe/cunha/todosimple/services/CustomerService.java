package com.phelipe.cunha.todosimple.services;
import com.phelipe.cunha.todosimple.models.Customer;
import com.phelipe.cunha.todosimple.repositores.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Long id){
		Optional<Customer> customer = this.customerRepository.findById(id);
		return customer.orElseThrow(() -> new RuntimeException("Cliente não encontrado! Id: " + id + ", Tipo: " + Customer.class.getName()));
	}

	@Transactional
	public Customer create(Customer customer){
		customer = this.customerRepository.save(customer);
		return customer;
	}

	@Transactional
	public Customer update(Customer customer){
		Customer newObj = findById(customer.getId());
		newObj.setName(customer.getName());
		newObj.setEndereco(customer.getEndereco());
		newObj.setNumero(customer.getNumero());
		newObj.setCep(customer.getCep());
		newObj.setComplemento(customer.getComplemento());
		return this.customerRepository.save(newObj);
	}
}
