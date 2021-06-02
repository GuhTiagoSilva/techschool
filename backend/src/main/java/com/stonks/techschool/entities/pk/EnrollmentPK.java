package com.stonks.techschool.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stonks.techschool.entities.Course;
import com.stonks.techschool.entities.User;

@Embeddable
public class EnrollmentPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	public EnrollmentPK() {
		
	}

	public EnrollmentPK(User user, Course course) {
		super();
		this.user = user;
		this.course = course;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
