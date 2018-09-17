package by.htp.epam.bonjo.domain;

import java.io.Serializable;

/**
 * Class describing Category entity
 * 
 * @author George Krasutki
 *
 */
public class Category implements Serializable {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -4910595516445814317L;

	/**
	 * Category id
	 */
	private int id;
	/**
	 * Category name
	 */
	private String name;

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 *            {@link #id}
	 * @param name
	 *            {@link #name}
	 */
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Constructor without parameters
	 */
	public Category() {
	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets category id
	 * 
	 * @param id
	 *            {@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets category name
	 * 
	 * @param name
	 *            {@link #name}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Category{" + "ID=" + id + ", Name='" + name + '\'' + '}';
	}

}