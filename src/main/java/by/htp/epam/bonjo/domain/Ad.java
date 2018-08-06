package by.htp.epam.bonjo.domain;

import java.io.Serializable;

public class Ad implements Serializable {

	private static final long serialVersionUID = -2329117546911802391L;

	private int id;
	private String title, smallDesc, description;
	private int price;
	private int users_ID, category_ID;

	public Ad(int id, String title, String smallDesc, String description, int price, int users_ID, int category_ID) {
		super();
		this.id = id;
		this.title = title;
		this.smallDesc = smallDesc;
		this.description = description;
		this.price = price;
		this.users_ID = users_ID;
		this.category_ID = category_ID;
	}

	public Ad() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSmallDesc() {
		return smallDesc;
	}

	public void setSmallDesc(String smallDesc) {
		this.smallDesc = smallDesc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(int users_ID) {
		this.users_ID = users_ID;
	}

	public int getCategory_ID() {
		return category_ID;
	}

	public void setCategory_ID(int category_ID) {
		this.category_ID = category_ID;
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

}