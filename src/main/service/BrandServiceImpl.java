package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Brand;
import main.repository.BrandRepository;

/**
 * 廠牌服務接口
 * @author sam
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> getAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand getById(long brandId) {
		return brandRepository.getOne(brandId);
	}

	@Override
	public void saveOrUpdate(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	public void delete(long brandId) {
		brandRepository.deleteById(brandId);
	}

}
