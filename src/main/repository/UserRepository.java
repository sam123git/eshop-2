package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.User;

/**
 * 用戶repository
 * @author sam
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public boolean existsByLogin(String login);
	
	public User findByLogin(String login);
	
}
