package by.htp.epam.bonjo.service.impl;

import java.util.List;

import by.htp.epam.bonjo.dao.CategoryDAO;
import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDao = DAOFactory.getDaoInstance().getCategoryDao();

	@Override
	public void create(Category category) {
		categoryDao.create(category);
		
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(int categoryId) {
		categoryDao.delete(categoryId);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.readAll();
	}

	@Override
	public Category read(int id) {
		return categoryDao.read(id);
	}


}
