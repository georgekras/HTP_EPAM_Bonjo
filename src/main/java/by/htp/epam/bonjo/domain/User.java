package by.htp.epam.bonjo.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 7149316319217521151L;

	private int id;
	private String login, email, password, nickname, phoneNumber;
	private int roles_ID;

	public User() {

	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String setPassword(String password) {
		return this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String setPhoneNumber(String phoneNumber) {
		return this.phoneNumber = phoneNumber;
	}

	public int getRoles_ID() {
		return roles_ID;
	}

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

	@Override
	public String toString() {
		return "User{" + "ID=" + id + ", Login='" + login + '\'' + ", Email='" + email + '\'' + ", Password='"
				+ password + '\'' + ", Nickname='" + nickname + '\'' + ", PhoneNumber='" + phoneNumber + '\''
				+ ", roles_ID=" + roles_ID + '}';
	}

	public static Builder newBuilder() {
		return new User().new Builder();
	}

	public class Builder {

		private Builder() {
		}

		public Builder setId(int id) {
			User.this.id = id;
			return this;
		}

		public Builder setLogin(String login) {
			User.this.login = login;
			return this;
		}

		public Builder setEmail(String email) {
			User.this.email = email;
			return this;
		}

		public Builder setPassword(String password) {
			User.this.password = password;
			return this;
		}

		public Builder setNickname(String nickname) {
			User.this.nickname = nickname;
			return this;
		}

		public Builder setPhoneNumber(String phoneNumber) {
			User.this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder setRolesId(int roles_ID) {
			User.this.roles_ID = roles_ID;
			return this;
		}

		public User build() {
			return User.this;
		}
	}

}