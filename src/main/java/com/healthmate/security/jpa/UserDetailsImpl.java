package com.healthmate.security.jpa;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.healthmate.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	// User 엔티티 타입의 참조변수 선언
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	// User이 가지고 있는 권한 목록을 저장하여 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 목록을 저장할 컬렉션
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		
		//권한 설정
		roleList.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return "ROLE_" + user.getRole();
			}
		});
		return roleList;
	}

	@Override
	public String getPassword() {
		// {noop}은 비밀번호를 암호화하지 않도록 하는 접두사이다
		return "{noop}" + user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	
	//  계정이 만료됬는지 여부를 리턴한다. 만료된 계정으로 로그인하면 에러난다.
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있는지 여부를 리턴한다.(휴먼)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//비밀번호가 만료되었는지 여부를 리턴한다.
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화된 여부를 리턴한다.
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
