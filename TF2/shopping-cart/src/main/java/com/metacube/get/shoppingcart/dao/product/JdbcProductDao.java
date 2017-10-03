package com.metacube.get.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.get.shoppingcart.Status;
import com.metacube.get.shoppingcart.dao.GenericJdbcDao;
import com.metacube.get.shoppingcart.model.Product;
/**
 * ClassName  :JdbcProductDao 
 * @author    :  Vaishali Jain
 * Description: Class implementing functions that are declared in Generic JdbcDao.
 */

public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao
{
	private String tableName;
	
	@Override protected String getTableName()
	{
		return tableName;
	}

	@Override protected Product extractResultSetRow(final ResultSet resultSet)
	{
		Product product = new Product();

		try
		{
			product.setPrice(resultSet.getDouble("price"));
			product.setName(resultSet.getString("name"));
			product.setImageUrl(resultSet.getString("imageUrl"));
			product.setId(resultSet.getInt("id"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}

	@Override protected String getPrimaryKeyColoumnName()
	{
		return "id";
	}

	@Override
	protected String setData(Product entity) {
		return "'"+entity.getName()+"', "+entity.getPrice()+"', '"+entity.getImageUrl()+"'";
	}

	@Override
	protected String getColumns() {
		
		return null;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
