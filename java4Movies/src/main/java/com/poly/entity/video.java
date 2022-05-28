package com.poly.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class video {
	@Id
	private String VideoId;
	
	private String Title;
	
	private String Href;
	
	private String Poster;
	
	private String Panner;
	
	private Date Date;
	
	private String Time;
	
	private String Description;
	
	private boolean Active;
	
	private int Views;
	
	private String VideoTrailler;
	
	@OneToMany(mappedBy = "video")
	List<favorite> favorite;
	
	@OneToMany(mappedBy = "video")
	List<share> share;

	public String getVideoId() {
		return VideoId;
	}

	public void setVideoId(String videoId) {
		VideoId = videoId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getHref() {
		return Href;
	}

	public void setHref(String href) {
		Href = href;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getPanner() {
		return Panner;
	}

	public void setPanner(String panner) {
		Panner = panner;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public int getViews() {
		return Views;
	}

	public void setViews(int views) {
		Views = views;
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

	public String getVideoTrailler() {
		return VideoTrailler;
	}

	public void setVideoTrailler(String videoTrailler) {
		VideoTrailler = videoTrailler;
	}
	
	
}
