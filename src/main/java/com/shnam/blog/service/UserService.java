package com.shnam.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shnam.blog.model.RoleType;
import com.shnam.blog.model.User;
import com.shnam.blog.repository.UserRepository;

//스피링이 컴포넌트 스캔을 해서 Bean에 등록 IOC
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void save(User user) {
		user.setRole(RoleType.USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
