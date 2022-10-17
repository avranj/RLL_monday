package com.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.Policy;

public interface PolicyDao extends JpaRepository<Policy, Integer>{

}
