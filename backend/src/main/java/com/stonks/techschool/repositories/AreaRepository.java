package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

}
