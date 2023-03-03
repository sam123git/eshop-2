package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Cart;
import main.repository.CartRepository;

/**
 * 購物車服務接口
 * @author sam
 *
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

	@Override
	public Cart getById(long cartId) {
		return cartRepository.getOne(cartId);
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public void delete(long cartId) {
		cartRepository.deleteById(cartId);
	}

}
