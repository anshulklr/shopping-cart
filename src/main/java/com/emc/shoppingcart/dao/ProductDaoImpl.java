
package com.emc.shoppingcart.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insertProduct(Product product) {
		String sql = "Insert into product (pId, pName, depID, quantity, price, prodDes) values (?, ?, ?, ?, ?, ?)";	
		jdbcTemplate.update(sql, product.getPId(), product.getpName(), product.getDepID(), product.getQuantity(), product.getPrice(), product.getProdDes());
		
		System.out.println("added product data");
		return;
	}

	@Override
	public void deleteProduct( int pId) {
		String sql = "delete from product where pId=?";
		jdbcTemplate.update(sql, pId);
		
		System.out.println("Product deleted");
		
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "select pId, pName, depID, quantity, price, prodDes from Product";
		List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return productList;
	}

	@Override
	public void updateProduct(Product product, int pId) {
		
		String sql = "update product set pId=?, pName=?, depID=?, quantity=?, price=?, prodDes=? where pId=? ";
		jdbcTemplate.update(sql, product.getPId(), product.getpName(), product.getDepID(), product.getQuantity(), product.getPrice(), product.getProdDes(),pId);
		System.out.println("Updated prdouct list");
		 	
	}

}
