package by.htp.epam.bonjo.web.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
	
	/**
	 * localization control
	 */
	LOCALIZATION("localization.msg");
	
	private ResourceBundle resourceBundle;

	/**
	 * resource name
	 */
	private final String resourceName;

	/**
	 * constructor with parameter
	 * 
	 * @param resourceName
	 *            name of resource
	 */
	private ResourceManager(String resourceName) {
		Locale.setDefault(Locale.US);
		this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
		this.resourceName = resourceName;
	}

	/**
	 * changes locale
	 * 
	 * @param locale
	 *            need locale
	 */
	public void changeResource(Locale locale) {
		resourceBundle = ResourceBundle.getBundle(resourceName, locale);
	}

	/**
	 * gets value by key
	 * 
	 * @param key
	 *            resource key
	 * @return value from property files
	 */
	public String getValue(String key) {
		return resourceBundle.getString(key);
	}
}
