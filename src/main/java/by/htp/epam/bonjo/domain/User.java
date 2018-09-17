package by.htp.epam.bonjo.domain;

import java.io.Serializable;

/**
 * Class describing User entity
 * 
 * @author George Krasutki
 *
 */
public class User implements Serializable {

	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 7149316319217521151L;

	/**
	 * User id
	 */
	private int id;
	/**
	 * User login
	 */
	private String login;
	/**
	 * User email
	 */
	private String email;
	/**
	 * User password
	 */
	private String password;
	/**
	 * User nickname
	 */
	private String nickname;
	/**
	 * User phone number
	 */
	private String phoneNumber;
	/**
	 * User role id
	 */
	private int roles_ID;

	/**
	 * Constructor without parameters
	 */
	public User() {

	}

	/**
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return {@link #login}
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return {@link #email}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return {@link #nickname}
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @return {@link #phoneNumber}
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return {@link #roles_ID}
	 */
	public int getRoles_ID() {
		return roles_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + roles_ID;
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (roles_ID != other.roles_ID)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "User{" + "ID=" + id + ", Login='" + login + '\'' + ", Email='" + email + '\'' + ", Password='"
				+ password + '\'' + ", Nickname='" + nickname + '\'' + ", PhoneNumber='" + phoneNumber + '\''
				+ ", roles_ID=" + roles_ID + '}';
	}

	/**
	 * Static method for create inner Builder class object
	 * 
	 * @return inner Builder class object
	 */
	public static Builder userBuilder() {
		return new User().new Builder();
	}

	/**
	 * Inner class for build User class object
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
			User.this.id = id;
			return this;
		}

		/**
		 * Sets login
		 * 
		 * @param login
		 *            {@link #login}
		 * @return Builder class object
		 */
		public Builder setLogin(String login) {
			User.this.login = login;
			return this;
		}

		/**
		 * Sets email
		 * 
		 * @param email
		 *            {@link #email}
		 * @return Builder class object
		 */
		public Builder setEmail(String email) {
			User.this.email = email;
			return this;
		}

		/**
		 * Sets password
		 * 
		 * @param password
		 *            {@link #password}
		 * @return Builder class object
		 */
		public Builder setPassword(String password) {
			User.this.password = password;
			return this;
		}

		/**
		 * Sets nickname
		 * 
		 * @param nickname
		 *            {@link #nickname}
		 * @return Builder class object
		 */
		public Builder setNickname(String nickname) {
			User.this.nickname = nickname;
			return this;
		}

		/**
		 * Sets phone number
		 * 
		 * @param phoneNumber
		 *            {@link #phoneNumber}
		 * @return Builder class object
		 */
		public Builder setPhoneNumber(String phoneNumber) {
			User.this.phoneNumber = phoneNumber;
			return this;
		}

		/**
		 * Sets role id
		 * 
		 * @param roles_ID
		 *            {@link #roles_ID}
		 * @return Builder class object
		 */
		public Builder setRolesId(int roles_ID) {
			User.this.roles_ID = roles_ID;
			return this;
		}

		/**
		 * @return ready User class object
		 */
		public User build() {
			return User.this;
		}
	}

}