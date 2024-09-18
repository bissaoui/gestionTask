package com.gestionTaches.services;

import java.util.List;

import com.gestionTaches.dto.UserDto;

public interface UserService {
    
    UserDto createUser(UserDto userDto);
    
    List<UserDto> getAllUsers();
    
    UserDto getUserById(Long id);
    
    UserDto updateUser(Long id, UserDto userDto);
    
    void deleteUser(Long id);
}