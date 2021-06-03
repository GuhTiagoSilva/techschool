package com.stonks.techschool.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM tb_area")
	List<Area> findAllWithNoPagination();
}
