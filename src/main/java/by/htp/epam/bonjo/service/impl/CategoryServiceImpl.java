package by.htp.epam.bonjo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.ad_project.dao.CategoryDao;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void create(Category category) {
		categoryDao.create(category);
		
	}

	@Override
	public Category read(int id) {
		return categoryDao.read(id);
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
