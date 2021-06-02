package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Company extends JpaRepository<Company, Long>{

}
