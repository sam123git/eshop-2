package main.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.Customer;

/**
 * 客戶repository
 * @author sam
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

//	@Query("from Customer c left join fetch c.comments where c.customerId = :customerId")
//	public Customer getByIdWithComments(@Param("customerId") long customerId);
	
	@Query("from User u where u.userId = :userId")
	public List<Customer> getByUserId(@Param("userId") long userId);
	
//	public Optional<Customer> findById(long customerId);
//	
//	public List<Customer> findAll();
	
}
