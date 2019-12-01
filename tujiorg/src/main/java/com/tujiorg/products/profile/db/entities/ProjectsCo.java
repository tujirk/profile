package com.tujiorg.products.profile.db.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects_co")
public class ProjectsCo {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="responsibility")
	private String responsibility;
	@Column(name="technology")
	private String technology;
	@Column(name="methdology")
	private String methdology;
	@Column(name="priroity")
	private int priroity;
	@OneToMany(mappedBy="fromEvent", fetch = FetchType.EAGER)
	private Set<Awards> awards;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriroity() {
		return priroity;
	}
	public void setPriroity(int priroity) {
		this.priroity = priroity;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getMethdology() {
		return methdology;
	}
	public void setMethdology(String methdology) {
		this.methdology = methdology;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Awards> getAwards() {
		return awards;
	}
	public void setAwards(Set<Awards> awards) {
		this.awards = awards;
	}
	
	@Override
	public String toString() {
		return "ProjectsCo [id=" + id + ", title=" + title + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", responsibility=" + responsibility + ", technology=" + technology
				+ ", methdology=" + methdology + ", priroity=" + priroity + ", awards=" + awards + "]";
	}
	
}
