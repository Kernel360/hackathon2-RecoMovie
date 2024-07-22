package com.hackathonteam2.recomovie.user.service;

import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean isUserExists(String loginId){
        return userRepository.existsByLoginId(loginId);
    }

    public boolean loginService(String loginId, String password){
        Optional<User> userOptional = userRepository.findByLoginId(loginId);
        if(userOptional.isEmpty()){
            return false;
        }
        User user = userOptional.get();
        String storePassword = user.getPassword();
        if(storePassword == null){
            return false;
        }
        return storePassword.equals(password);
    }

    public User getUserByLoginId(String loginId){
        return userRepository.findByLoginId(loginId).orElseThrow(()-> new IllegalArgumentException("Invalid login Id:"+loginId));
    }

}
