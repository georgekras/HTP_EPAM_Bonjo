package by.htp.epam.bonjo.service;

import java.util.List;

import by.htp.epam.bonjo.domain.Category;

/**
 * Interface provides specific methods for working with Category entity
 * 
 * {@link by.htp.epam.bonjo.domain.Category}
 * 
 * @author George Krasutski
 */
public interface CategoryService {

	/**
	 * Creates a new category
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity
	 */
	void create(Category category);

	/**
	 * Updates category
	 *
	 * @param category
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity
	 */
	void update(Category category);

	/**
	 * Deletes category
	 *
	 * @param categoryId
	 *            the {@link by.htp.epam.bonjo.domain.Category} entity
	 */
	void delete(int categoryId);

	/**
	 * Retrieves a list of categories
	 *
	 * @return {@code List<Category>} - the list of categories
	 */
	List<Category> getAllCategories();

	/**
	 * Find a category by id
	 *
	 * @param id
	 *            the id of a category
	 * @return {@link by.htp.epam.bonjo.domain.Category} category
	 */
	Category read(int id);

}