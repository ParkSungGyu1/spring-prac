package com.example.jpaprac.repository;

import com.example.jpaprac.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}