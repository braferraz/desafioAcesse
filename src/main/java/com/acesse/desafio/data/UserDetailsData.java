package com.acesse.desafio.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.acesse.desafio.model.User;


public class UserDetailsData implements UserDetails{

	/**
	 * s
	 */
	private static final long serialVersionUID = 3737526376392804748L;
	
	private final Optional<User> usu;
	
	public UserDetailsData(Optional<User> usu) {
		this.usu = usu;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return usu.orElse(new User()).getPassword();
	}

	@Override
	public String getUsername() {
		return usu.orElse(new User()).getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
