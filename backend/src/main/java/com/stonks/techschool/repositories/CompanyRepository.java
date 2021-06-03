package com.stonks.techschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stonks.techschool.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
