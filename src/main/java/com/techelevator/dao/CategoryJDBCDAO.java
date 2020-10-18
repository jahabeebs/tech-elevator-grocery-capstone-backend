package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Category;
@Component
public class CategoryJDBCDAO implements CategoryDAO {
	private JdbcTemplate template;
	public CategoryJDBCDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Category> viewProductsByCategory(int id) {
		String getCategory = "Select * from category where category_id = ?";
		List<Category> categories = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(getCategory, id);
		while(result.next()) {
			int categoryid = result.getInt("category_id");
			String categoryName = result.getNString("category_name");
			
			Category category = new Category(categoryid, categoryName);
			categories.add(category);
		}
		return categories;
	}
	public List<Category>getAllCategories(){
		String getCategory="select * from category";
		List<Category> categories = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(getCategory);
		while(result.next()) {
			String categoryName = result.getString("category_name");
			int categoryid = result.getInt("category_id");
			String categoryDescription = result.getString("description");
			Category category = new Category(categoryid, categoryName, categoryDescription);
			categories.add(category);
		}
		return categories;
	}

}
