package com.gestionTaches.services.impl;


import com.gestionTaches.dto.UserDto;
import com.gestionTaches.entities.User;
import com.gestionTaches.exceptions.ResourceNotFoundException;
import com.gestionTaches.repositories.UserRepository;
import com.gestionTaches.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return mapToDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }

    // Mapper pour convertir Entity en DTO
    private UserDto mapToDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }

    // Mapper pour convertir DTO en Entity
    private User mapToEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getUsername(), userDto.getEmail());
    }
}
