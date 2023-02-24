package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Product;
import main.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(long productId) {
		return productRepository.findById(productId).orElseGet(null);
	}

	@Override
	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}

	@Override
	public void delete(long productId) {
		productRepository.deleteById(productId);
	}

}
