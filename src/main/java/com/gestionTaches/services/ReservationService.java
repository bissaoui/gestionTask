package com.gestionTaches.services;

import java.util.List;

import com.gestionTaches.dto.ReservationDto;

import java.util.List;

public interface ReservationService {
    
    // Créer une réservation
	ReservationDto createReservation(ReservationDto reservation);
    
    // Obtenir toutes les réservations
    List<ReservationDto> getAllReservations();
    
    // Obtenir une réservation par ID
    ReservationDto getReservationById(Long id);
    
    // Obtenir les réservations par utilisateur
    List<ReservationDto> getReservationsByUser(Long userId);

    // Supprimer une réservation
    void deleteReservation(Long id);

    // Mettre à jour le statut de la réservation
    ReservationDto updateReservationStatus(Long reservationId, String status);
}
