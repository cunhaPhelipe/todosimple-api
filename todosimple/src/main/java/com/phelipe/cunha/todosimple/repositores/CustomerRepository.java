package com.phelipe.cunha.todosimple.repositores;

import com.phelipe.cunha.todosimple.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
