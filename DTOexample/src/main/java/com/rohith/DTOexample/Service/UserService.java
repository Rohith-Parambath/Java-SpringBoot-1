package com.rohith.DTOexample.Service;

import com.rohith.DTOexample.DTO.UserDTO;
import com.rohith.DTOexample.Repository.UserRepo;
import com.rohith.DTOexample.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDtos = users.stream()
                .map(e -> new UserDTO(e.getName(), e.getDob(), e.getEmail()))
                .collect(Collectors.toList());

        return userDtos;
    }

    public UserDTO getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return new UserDTO(user.getName(), user.getDob(), user.getEmail());
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(Long id, User updateUserDetails) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (updateUserDetails.getName() != null && !updateUserDetails.getName().isBlank()) {
            user.setName(updateUserDetails.getName());
        }

        if (updateUserDetails.getDob() != null) {
            user.setDob(updateUserDetails.getDob());
        }

        if (updateUserDetails.getEmail() != null && !updateUserDetails.getEmail().isBlank()) {
            user.setEmail(updateUserDetails.getEmail());
        }

        if (updateUserDetails.getPassword() != null && !updateUserDetails.getPassword().isBlank()) {
            user.setPassword(updateUserDetails.getPassword());
        }

        return userRepo.save(user);

    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


}
