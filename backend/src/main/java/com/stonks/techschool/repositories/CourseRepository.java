package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
