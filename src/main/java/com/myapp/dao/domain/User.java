package com.myapp.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user",  schema="myapp")
public class User {
	@Id
	@Column(name = "id")  
	String id;
	@Column(name = "username")  
	String username;
	@Column(name = "password")  
	String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 @Override
	public boolean equals(Object o) {
	     if (this == o) return true;
	     if (o == null || getClass() != o.getClass()) return false;
	       User user = (User) o;
	     return username.equals(user.username);
	}
	 
	@Override
	public int hashCode() {
	    return 13 * username.hashCode();
	}
}
