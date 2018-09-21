package by.htp.epam.bonjo.domain;

import java.io.Serializable;

/**
 * Class describing Ad entity
 * 
 * @author George Krasutki
 *
 */
public class Ad implements Serializable {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = -2329117546911802391L;

	/**
	 * Ad id
	 */
	private int id;
	/**
	 * Ad title
	 */
	private String title;
	/**
	 * Ad small description
	 */
	private String smallDesc;
	/**
	 * Ad description
	 */
	private String description;
	/**
	 * Ad price
	 */
	private int price;
	/**
	 * Ad users id
	 */
	private int users_ID;
	/**
	 * Ad category id
	 */
	private int category_ID;

	/**
	 * Constructor without parameters
	 */
	public Ad() {

	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return {@link #title}
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return {@link #smallDesc}
	 */
	public String getSmallDesc() {
		return smallDesc;
	}

	/**
	 * @return {@link #description}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return {@link #price}
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return {@link #users_ID}
	 */
	public int getUsers_ID() {
		return users_ID;
	}

	/**
	 * @return {@link #category_ID}
	 */
	public int getCategory_ID() {
		return category_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_ID;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + ((smallDesc == null) ? 0 : smallDesc.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + users_ID;
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
		Ad other = (Ad) obj;
		if (category_ID != other.category_ID)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (smallDesc == null) {
			if (other.smallDesc != null)
				return false;
		} else if (!smallDesc.equals(other.smallDesc))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (users_ID != other.users_ID)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Ad{" + "ID=" + id + ", Title='" + title + '\'' + ", SmallDesc='" + smallDesc + '\'' + ", Description='"
				+ description + '\'' + ", Price=" + price + ", users_ID=" + users_ID + ", category_ID=" + category_ID
				+ '}';
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder adBuilder() {
		return new Ad().new Builder();
	}

	/**
	 * Inner class for build Ad class object
	 * 
	 * @author George Krasutski
	 *
	 */
	public class Builder {

		/**
		 * Constructor without parameters
		 */
		private Builder() {
		}

		/**
		 * Sets id
		 * 
		 * @param id
		 *            {@link #id}
		 * @return Builder class object
		 */
		public Builder setId(int id) {
			Ad.this.id = id;
			return this;
		}

		/**
		 * Sets title
		 * 
		 * @param title
		 *            {@link #title}
		 * @return Builder class object
		 */
		public Builder setTitle(String title) {
			Ad.this.title = title;
			return this;
		}

		/**
		 * Sets small description
		 * 
		 * @param smallDesc
		 *            {@link #smallDesc}
		 * @return Builder class object
		 */
		public Builder setSmallDesc(String smallDesc) {
			Ad.this.smallDesc = smallDesc;
			return this;
		}

		/**
		 * Sets description
		 * 
		 * @param description
		 *            {@link #description}
		 * @return Builder class object
		 */
		public Builder setDescription(String description) {
			Ad.this.description = description;
			return this;
		}

		/**
		 * Sets price
		 * 
		 * @param price
		 *            {@link #price}
		 * @return Builder class object
		 */
		public Builder setPrice(int price) {
			Ad.this.price = price;
			return this;
		}

		/**
		 * Sets users id
		 * 
		 * @param users_ID
		 *            {@link #users_ID}
		 * @return Builder class object
		 */
		public Builder setUsersId(int users_ID) {
			Ad.this.users_ID = users_ID;
			return this;
		}

		/**
		 * Sets category id
		 * 
		 * @param category_ID
		 *            {@link #category_ID}
		 * @return Builder class object
		 */
		public Builder setCategoryId(int category_ID) {
			Ad.this.category_ID = category_ID;
			return this;
		}

		/**
		 * @return ready Ad class object
		 */
		public Ad build() {
			return Ad.this;
		}
	}

}