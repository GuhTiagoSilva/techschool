package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
