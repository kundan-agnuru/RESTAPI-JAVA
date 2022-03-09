package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userById = userRepository.findUserById(user.getId());
        if(userById.isPresent()){
            throw new IllegalStateException("Id exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with " + userId+ " does not exist");
        }
        userRepository.deleteById(userId);

    }

    public void updateUser(User user) {
        Optional<User> userById = userRepository.findUserById(user.getId());
        if(!userById.isPresent()){
            throw new IllegalStateException("Id does not exists");
        }
        User u = userRepository.getById(user.getId());
        u.setFname(user.getFname());
        u.setLname(user.getLname());
        u.setClub(user.getClub());
        userRepository.save(u);
    }
}
