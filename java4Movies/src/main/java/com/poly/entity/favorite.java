package com.poly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="favorite",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"UserId","VideoId"})
})
public class favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long FavoriteId;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	private users user;
	
	@ManyToOne
	@JoinColumn(name = "VideoId")
	private video video;
	
	@Temporal(TemporalType.DATE)
	private Date LikeDate = new Date();

	public long getFavoriteId() {
		return FavoriteId;
	}

	public void setFavoriteId(long favoriteId) {
		FavoriteId = favoriteId;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public video getVideo() {
		return video;
	}

	public void setVideo(video video) {
		this.video = video;
	}

	public Date getLikeDate() {
		return LikeDate;
	}

	public void setLikeDate(Date likeDate) {
		LikeDate = likeDate;
	}

	public favorite(long favoriteId, users user, com.poly.entity.video video, Date likeDate) {
		FavoriteId = favoriteId;
		this.user = user;
		this.video = video;
		LikeDate = likeDate;
	}
	public favorite( users user, video videoid) {
		this.user = user;
		this.video = videoid;
	}
	
	public favorite() {
		
	}
	
}
