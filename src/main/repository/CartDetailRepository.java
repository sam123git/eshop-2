package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.CartDetail;

/**
 * 購物車repository
 * @author sam
 *
 */
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
