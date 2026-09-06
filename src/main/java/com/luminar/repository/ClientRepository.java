package com.luminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luminar.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
