package com.tujiorg.products.profile.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects_ho")
public class ProjectsHo {
	@Id
	@Column
	private String id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String technology;
	@Column
	private String url;
	@Column(name="logo_url")
	private String logoUrl;
	@Column
	private int priroity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public int getPriroity() {
		return priroity;
	}
	public void setPriroity(int priroity) {
		this.priroity = priroity;
	}

	@Override
	public String toString() {
		return "ProjectsHo [id=" + id + ", title=" + title + ", description=" + description + ", technology="
				+ technology + ", url=" + url + ", logoUrl=" + logoUrl + ", priroity=" + priroity + "]";
	}
	
}
