package com.example.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserApiController {
	private final UserRepository userRepository;
	
	// 회원정보 등록 
	@PostMapping("users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		log.info("user : {}", user);
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	// 회원정보 전체 조회 
	@GetMapping("users")
	public ResponseEntity<List<User>> findAllUsers(){
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
