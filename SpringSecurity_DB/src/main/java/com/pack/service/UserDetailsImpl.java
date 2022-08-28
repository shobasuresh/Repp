package com.pack.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pack.model.User;

public class UserDetailsImpl implements UserDetails {

	 

	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public UserDetailsImpl() {}

	
	  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	  System.out.println("auth "+authorities); return authorities; }
	  
	  @Override public String getPassword() { System.out.println("pass "+password);
	  return password; }
	  
	  @Override public String getUsername() { System.out.println("user "+userName);
	  return userName; }
	  
	  @Override public boolean isAccountNonExpired() { return true; }
	  
	  @Override public boolean isAccountNonLocked() { return true; }
	  
	  @Override public boolean isCredentialsNonExpired() { return true; }
	  
	  @Override public boolean isEnabled() { return isActive; }
	 
}