package by.htp.epam.bonjo.service;

import by.htp.epam.bonjo.service.impl.AdServiceImpl;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;

/**
 * Factory provides service instances
 * 
 * @author George Krasutski
 */
public class ServiceFactory {

	/**
	 * Singleton instance
	 */
	private static final ServiceFactory serviceInstance = new ServiceFactory();
	
	/**
	 * AdServiceImpl instance
	 */
	private AdService adService = new AdServiceImpl();
	/**
	 * CategoryServiceImpl instance
	 */
	private CategoryService categoryService = new CategoryServiceImpl();
	/**
	 * UserServiceImpl instance
	 */
	private UserService userService = new UserServiceImpl();

	/**
	 * static method for getting instance of service factory
	 * 
	 * @return {@link #serviceInstance}
	 */
	public static ServiceFactory getServiceInstance() {
		return serviceInstance;
	}

	/**
	 * @return {@link #adService}
	 */
	public AdService getAdService() {
		return adService;
	}

	/**
	 * @return {@link #categoryService}
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * @return {@link #userService}
	 */
	public UserService getUserService() {
		return userService;
	}

}
