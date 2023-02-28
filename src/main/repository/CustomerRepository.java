package main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

//	@Query("from Customer t left join fetch t.comments where t.customerId = :customerId")
//	public Customer getByIdWithComments(@Param("customerId") long customerId);
	
//	public Optional<Customer> findById(long customerId);
//	
//	public List<Customer> findAll();
	
}
