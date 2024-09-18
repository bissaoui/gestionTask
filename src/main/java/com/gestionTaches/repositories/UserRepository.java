package com.gestionTaches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionTaches.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}