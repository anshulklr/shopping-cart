package com.emc.shoppingcart.service;

import java.util.List;

import com.emc.shoppingcart.model.Product;
public interface ProductService {
	public void createProduct(Product product);
	public void deleteProduct(int pId);
	public List<Product> displayAllProduct();
	public void updateProduct(Product product , int pId);
}
