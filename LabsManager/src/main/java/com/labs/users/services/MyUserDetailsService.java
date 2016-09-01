package com.labs.users.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.labs.users.model.Role;

public class MyUserDetailsService implements UserDetailsService {

	private DbService dbService;
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		com.labs.users.model.User user = dbService.getUserByName(username);
		if(user != null){
			List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
			System.out.println("username : "+ username);
			return buildUserForAuthentication(user, authorities);
		}else{
			return null;
		}
		
	}

	// Converts com.labs.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.labs.users.model.User user, List<GrantedAuthority> authorities) {
		System.out.println("password : "+user.getPassword());
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {

		System.out.println("building user authority...");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Role role : roles) {
			System.out.println("role: "+ role.getRole());
			setAuths.add(new SimpleGrantedAuthority(role.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public DbService getDbService() {
		return dbService;
	}

	public void setDbService(DbService dbService) {
		this.dbService = dbService;
	}

	
}