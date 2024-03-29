package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
