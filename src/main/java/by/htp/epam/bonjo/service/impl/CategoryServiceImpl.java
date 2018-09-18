package by.htp.epam.bonjo.service.impl;

import java.util.List;

import by.htp.epam.bonjo.dao.CategoryDAO;
import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Category;
import by.htp.epam.bonjo.service.CategoryService;

/**
 * Class implementing CategoryService interface
 * 
 * @author George Krasutski
 *
 */
public class CategoryServiceImpl implements CategoryService {

	/**
	 * CategoryDao instance
	 */
	private CategoryDAO categoryDao = DAOFactory.getDaoInstance().getCategoryDao();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(Category category) {
		categoryDao.create(category);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(int categoryId) {
		categoryDao.delete(categoryId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.readAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Category read(int id) {
		return categoryDao.read(id);
	}
}