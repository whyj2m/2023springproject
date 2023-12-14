package com.study.springboot.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.api.request.AddUserRequest;
import com.study.springboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApi {
	
	private final UserService userService;
	
	@Operation(summary = "회원가입", description = "UserJoin")
	@PostMapping("/api/join")
	public String join(@RequestBody AddUserRequest request) {
		String email = request.getEmail();
		if(userService.isEmailAlreadyExists(email)) {
			return "이메일이 중복입니다";
		}
		
		Long userId = userService.save(request);
		return "아이디가 생성되었습니다. " + userId;
	}
	
	@PostMapping("/api/login")
	public String login(@RequestBody AddUserRequest request) {
		return userService.login(request);
	}
}
