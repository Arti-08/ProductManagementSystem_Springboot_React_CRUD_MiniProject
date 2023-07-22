package com.arti08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arti08.model.Product;
import com.arti08.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepo.findById(id).get();

		if (product != null) {
			productRepo.delete(product);
			return "Product Delete Successfully";
		}
		return "Something went Wrong";
	}

	@Override
	public Product editProduct(Product product, Integer id) {

		Product oldproduct = productRepo.findById(id).get();

		oldproduct.setProductName(product.getProductName());
		oldproduct.setDescription(product.getDescription());
		oldproduct.setPrice(product.getPrice());
		oldproduct.setStatus(product.getStatus());

		return productRepo.save(oldproduct);
	}

}
