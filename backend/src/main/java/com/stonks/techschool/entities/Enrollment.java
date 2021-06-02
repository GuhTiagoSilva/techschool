package com.stonks.techschool.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.stonks.techschool.entities.pk.EnrollmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EnrollmentPK pk = new EnrollmentPK();
	private Instant enrollMoment;
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;
	
	public Enrollment() {
		
	}

	public Enrollment(User user, Course course, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();
		this.pk.setUser(user);
		this.pk.setCourse(course);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public User getUser() {
		return this.pk.getUser();
	}

	public void setPk(User user) {
		this.pk.setUser(user);
	}
	
	public Course getCourse() {
		return this.pk.getCourse();
	}
	
	public void setCourse(Course course) {
		this.pk.setCourse(course);
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

}
