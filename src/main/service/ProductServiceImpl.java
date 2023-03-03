package main.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Product;
import main.repository.ProductRepository;

/**
 * 產品服務接口
 * @author sam
 *
 */
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

	/**
	 *create time＆update time logic set here
	 */
	@Override
	public void saveOrUpdate(Product product) {
		Date setDate = new Date();
		 if (product.getProductId()!=0) {
			 product.setUpdateTime(setDate);
			 product.getBrand().setUpdateTime(setDate);
	        } else {
	        	product.setCreateTime(setDate);

	        }
		productRepository.save(product);
	}

	@Override
	public void delete(long productId) {
		productRepository.deleteById(productId);
	}

}
