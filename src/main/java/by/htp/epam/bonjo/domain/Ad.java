package by.htp.epam.bonjo.domain;

import java.io.Serializable;

public class Ad implements Serializable {

	private static final long serialVersionUID = -2329117546911802391L;

	private int id;
	private String title;
	private String smallDesc;
	private String description;
	private int price;
	private int users_ID;
	private int category_ID;
	
	public Ad() {
		
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getSmallDesc() {
		return smallDesc;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getUsers_ID() {
		return users_ID;
	}

	public int getCategory_ID() {
		return category_ID;
	}

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

	@Override
	public String toString() {
		return "Ad{" + "ID=" + id + ", Title='" + title + '\'' + ", SmallDesc='" + smallDesc + '\'' + ", Description='"
				+ description + '\'' + ", Price=" + price + ", users_ID=" + users_ID + ", category_ID=" + category_ID
				+ '}';
	}
	
	public static Builder adBuilder() {
		return new Ad().new Builder();
	}

	public class Builder {

		private Builder() {
		}

		public Builder setId(int id) {
			Ad.this.id = id;
			return this;
		}

		public Builder setTitle(String title) {
			Ad.this.title = title;
			return this;
		}

		public Builder setSmallDesc(String smallDesc) {
			Ad.this.smallDesc = smallDesc;
			return this;
		}

		public Builder setDescription(String description) {
			Ad.this.description = description;
			return this;
		}

		public Builder setPrice(int price) {
			Ad.this.price = price;
			return this;
		}

		public Builder setUsersId(int users_ID) {
			Ad.this.users_ID = users_ID;
			return this;
		}

		public Builder setCategoryId(int category_ID) {
			Ad.this.category_ID = category_ID;
			return this;
		}

		public Ad build() {
			return Ad.this;
		}
	}

}