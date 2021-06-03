package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
