package com.shnam.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {
	
	@Test
	public void hashEnc() {
		String encPasswd = new BCryptPasswordEncoder().encode("1234");
		System.out.println("encPasswd :" + encPasswd);
	}
}
