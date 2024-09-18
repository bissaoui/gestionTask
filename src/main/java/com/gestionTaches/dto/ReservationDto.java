package com.gestionTaches.dto;
import java.util.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservationDto {
    private Long id;
    private Date reservationDate;
    private String status;
    private Long userId;
    private Long itemId;

    // Constructeurs, Getters, et Setters
}