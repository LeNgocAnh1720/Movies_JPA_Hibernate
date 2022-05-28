package com.poly.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class users {
	@Id
	private String UserId;
	
	private String Password;
	
	private String Email;
	
	private String FullName;
	
	private boolean isAdmin;
	
	@OneToMany(mappedBy = "user")
	List<favorite> favorite;
	
	@OneToMany(mappedBy = "user")
	List<share> share;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<favorite> favorite) {
		this.favorite = favorite;
	}

	public List<share> getShare() {
		return share;
	}

	public void setShare(List<share> share) {
		this.share = share;
	}

	public users(String userId, String password, String email, String fullName, boolean isAdmin) {
		UserId = userId;
		Password = password;
		Email = email;
		FullName = fullName;
		this.isAdmin = false;
	}
	
	public users() {
		
	}
}
