package com.gestionTaches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionTaches.entities.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
}