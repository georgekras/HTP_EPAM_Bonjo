package by.htp.epam.bonjo.service.impl;

import java.util.List;

import by.htp.epam.bonjo.dao.CategoryDAO;
import by.htp.epam.bonjo.dao.impl.CategoryDaoImpl;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDao = new CategoryDaoImpl();

	@Override
	public void create(Category category) {
		categoryDao.create(category);
		
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.readAll();
	}


}
