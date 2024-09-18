package com.gestionTaches.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Déclare une exception pour une ressource non trouvée
@ResponseStatus(value = HttpStatus.NOT_FOUND)  // Associe l'exception au code HTTP 404
public class ResourceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
