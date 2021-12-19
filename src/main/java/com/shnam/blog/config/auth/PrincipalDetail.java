package com.shnam.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shnam.blog.model.User;

public class PrincipalDetail implements UserDetails{
	
	private User user;
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 여부 (true : 만료되지 않음)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정 잠기지 않았는지 여부 (true : 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호 만료되지 않았는지 여부 (true : 만료되지 않음)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계쩡이 활성화인지 여부 (true : 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//계정이 갖고있는 권한 목록을 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(() -> {
				return "ROLE_" + user.getRole();
			});
		
		return collectors;
	}
}
