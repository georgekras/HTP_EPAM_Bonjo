package by.htp.epam.bonjo.domain;

import java.io.Serializable;

/**
 * Class describing Role entity
 * 
 * @author George Krasutki
 *
 */
public class Role implements Serializable {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -608201873958322100L;

	/**
	 * Role id
	 */
	private int id;
	/**
	 * Role name
	 */
	private String roleName;

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 *            {@link #id}
	 * @param roleName
	 *            {@link #roleName}
	 */
	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	/**
	 * Constructor without parameters
	 */
	public Role() {
	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets role id
	 * 
	 * @param id
	 *            {@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return {@link #roleName}
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets role name
	 * 
	 * @param roleName
	 *            {@link #roleName}
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Role{" + "ID=" + id + ", Role='" + roleName + '\'' + '}';
	}

}