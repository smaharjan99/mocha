package com.cubic.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")

public class StudentEntity {

	@Id
	@Column(name = "STD_ID")
	@SequenceGenerator(name = "stdSeq", sequenceName = "STD_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "stdSeq")
	private Long pk;

	@Column(name = "STD_NAME")
	private String stdName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "students")
	private List<CourseEntity> courses;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public List<CourseEntity> getCourses() {

		if (this.courses == null) {
			this.courses = new ArrayList<CourseEntity>();
		}
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentEntity [pk=" + pk + ", stdName=" + stdName + "]";
	}

}
