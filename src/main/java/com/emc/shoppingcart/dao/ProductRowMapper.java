package com.emc.shoppingcart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emc.shoppingcart.model.Product;

public class ProductRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Product prod = new Product();
		prod.setPId(rs.getInt(0));
		prod.setpName(rs.getString(1));
		prod.setDepID(rs.getInt(2));
		prod.setQuantity(rs.getInt(3));
		prod.setPrice(rs.getInt(4));
		prod.setProdDes(rs.getString(5));
		
		
		return null;
	}
	

}
