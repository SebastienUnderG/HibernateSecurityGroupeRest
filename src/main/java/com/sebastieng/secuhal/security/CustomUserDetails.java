package com.sebastieng.secuhal.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sebastieng.secuhal.entity.MyUser;
import com.sebastieng.secuhal.entity.Roles;
import com.sebastieng.secuhal.repository.MyUserRepository;

import lombok.Data;

@Data
public class CustomUserDetails extends MyUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2898711357787979634L;
	
    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Roles> role;

	public CustomUserDetails(final MyUser user) {
		super();
		this.setUt(user.getUt());
		this.setPassword(user.getPassword());
		this.setRole(user.getGroupe().getRole().stream().collect(Collectors.toSet()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
				.collect(Collectors.toList());
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MyUserRepository userRepository;

	public void save(MyUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
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

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}