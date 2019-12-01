package com.tujiorg.products.profile.db.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="awards")
public class Awards {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="img_url")
	private String imgUrl;
	@Column(name="date")
	private Date date;
	@Column(name="priroity")
	private int priroity;
	@Column(name="from_event")
	private String fromEvent;
	
	
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPriroity() {
		return priroity;
	}
	public void setPriroity(int priroity) {
		this.priroity = priroity;
	}
	public String getFromEvent() {
		return fromEvent;
	}
	public void setFromEvent(String fromEvent) {
		this.fromEvent = fromEvent;
	}

	@Override
	public String toString() {
		return "Awards [id=" + id + ", title=" + title + ", imgUrl=" + imgUrl + ", date=" + date + ", priroity="
				+ priroity + ", fromEvent=" + fromEvent + "]";
	}
}
