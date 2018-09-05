package by.htp.epam.bonjo.service;

import by.htp.epam.bonjo.service.impl.AdServiceImpl;
import by.htp.epam.bonjo.service.impl.CategoryServiceImpl;
import by.htp.epam.bonjo.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory serviceInstance = new ServiceFactory();
	
	private AdService adService = new AdServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	public static ServiceFactory getServiceInstance() {
		return serviceInstance;
	}

	public AdService getAdService() {
		return adService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public UserService getUserService() {
		return userService;
	}

}
