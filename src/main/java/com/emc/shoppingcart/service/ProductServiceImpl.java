package com.emc.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shoppingcart.dao.ProductDao;
import com.emc.shoppingcart.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	
	@Override
	public void createProduct(Product product) {
		productDao.insertProduct(product);
	}

	@Override
	public void deleteProduct(int pId) {
		productDao.deleteProduct(pId);	
	}

	@Override
	public List<Product> displayAllProduct() {
		List<Product> productList = productDao.getAllProducts();
		return productList;
	}

	@Override
	public void updateProduct(Product product, int pId) {
		productDao.updateProduct(product, pId);	
	}

}
