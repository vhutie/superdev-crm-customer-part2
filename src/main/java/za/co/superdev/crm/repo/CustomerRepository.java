package za.co.superdev.crm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.superdev.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByName(String name);

  Customer findById(long id);
}