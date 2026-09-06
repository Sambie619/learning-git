package com.luminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luminar.entity.Ad;

public interface AdRepository extends JpaRepository<Ad, Integer> {

}
