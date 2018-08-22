package by.htp.epam.bonjo.service;

import java.util.List;

import by.htp.epam.bonjo.domain.Category;


public interface CategoryService {

	void create(Category category);
	
	void update(Category category);
	
	void delete(int categoryId);
	
	List<Category> getAllCategories();
	
	Category read(int id);

}
