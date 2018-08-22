package by.htp.epam.bonjo.dao;

import java.util.List;

import by.htp.epam.bonjo.domain.Category;

public interface CategoryDAO {

	void create(Category category);
	
	Category read(int id);
	
	List<Category> readAll();
	
	void update(Category category);
	
	void delete(int id);
	
	
	
}
