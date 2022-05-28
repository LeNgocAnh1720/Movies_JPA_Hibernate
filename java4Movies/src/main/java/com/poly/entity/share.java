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
@Table(name="share",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"UserId","VideoId"})
})
public class share {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ShareId;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private users user;
	
	@ManyToOne
	@JoinColumn(name="VideoId")
	private video video;
	
	private String Emails;
	
	@Temporal(TemporalType.DATE)
	private Date ShareDate = new Date();

	public long getShareId() {
		return ShareId;
	}

	public void setShareId(long shareId) {
		ShareId = shareId;
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

	public String getEmails() {
		return Emails;
	}

	public void setEmails(String emails) {
		Emails = emails;
	}

	public Date getShareDate() {
		return ShareDate;
	}

	public void setShareDate(Date shareDate) {
		ShareDate = shareDate;
	}

	public share(users user, video video, String emails) {
		this.user = user;
		this.video = video;
		Emails = emails;
	}
	public share() {
	}
	
}
