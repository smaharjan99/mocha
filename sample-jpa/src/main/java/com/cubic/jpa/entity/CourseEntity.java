package com.cubic.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")

public class CourseEntity {

	@Id
	@Column(name = "COR_ID")
	@SequenceGenerator(name = "corSeq", sequenceName = "COR_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "corSeq")
	private Long pk;

	@Column(name = "COR_NAME")
	private String corName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "COURSE") , inverseJoinColumns = @JoinColumn(name = "STUDENT") )
	private List<StudentEntity> students;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getCorName() {
		return corName;
	}

	public void setCorName(String corName) {
		this.corName = corName;
	}

	public List<StudentEntity> getStudents() {
		if (this.students == null) {
			this.students = new ArrayList<StudentEntity>();
		}
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "CourseEntity [pk=" + pk + ", corName=" + corName + "]";
	}

}
