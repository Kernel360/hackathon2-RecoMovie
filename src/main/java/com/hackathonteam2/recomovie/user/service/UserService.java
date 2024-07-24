package com.hackathonteam2.recomovie.user.service;

import com.hackathonteam2.recomovie.user.dto.LoginRequest;
import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final HttpSession session;

    private final Path rootLocation = Paths.get("upload-dir");

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

    // 사용자 생성 메서드
    public User createUser(String loginId, String password, String name, String email, String nickname, MultipartFile profileImage) throws IOException {
        if (isUserExists(loginId)) {
            throw new IllegalArgumentException("User already exists with login ID: " + loginId);
        }

        String profileImageUrl = null;
        if (profileImage != null && !profileImage.isEmpty()) {
            profileImageUrl = saveProfileImage(profileImage);
        }

        User user = new User(loginId, password, name, email, nickname, profileImageUrl);
        return userRepository.save(user);
    }

    private String saveProfileImage(MultipartFile profileImage) throws IOException {
        if (profileImage.isEmpty()) {
            return null;
        }
        Files.createDirectories(rootLocation);
        Path destinationFile = rootLocation.resolve(Paths.get(profileImage.getOriginalFilename())).normalize().toAbsolutePath();
        Files.copy(profileImage.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
        return "/images/" + profileImage.getOriginalFilename();
    }

    public User getCurrentUser() {
        String loginId = (String) session.getAttribute("loginId");
        if (loginId != null) {
            return userRepository.findByLoginId(loginId).orElse(null);
        }
        return null;
    }

}
