package com.stonks.techschool.dto;

import java.io.Serializable;
import java.time.Instant;

import com.stonks.techschool.entities.Enrollment;

public class EnrollmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private Long courseId;
	private Instant enrollMoment;
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;
	
	public EnrollmentDTO() {
		
	}
	
	public EnrollmentDTO(Enrollment entity) {
		userId = entity.getUser().getId();
		courseId = entity.getCourse().getId();
		enrollMoment = entity.getEnrollMoment();
		refundMoment = entity.getRefundMoment();
		available = entity.isAvailable();
		onlyUpdate = entity.isOnlyUpdate();
	}

	public EnrollmentDTO(Long userId, Long courseId, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();
		this.userId = userId;
		this.courseId = courseId;
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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
