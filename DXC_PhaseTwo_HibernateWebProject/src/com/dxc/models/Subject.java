package com.dxc.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String subjectname;
  @ManyToOne
  @JoinColumn(name="classes_id")
  private Class classes;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSubjectname() {
	return subjectname;
}
public void setSubjectname(String subjectname) {
	this.subjectname = subjectname;
}
public Class getClasses() {
	return classes;
}
public void setClasses(Class classes) {
	this.classes = classes;
}
  
}
