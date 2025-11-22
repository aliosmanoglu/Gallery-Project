package com.alihaydar.model;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails{

	
	private String username;

	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}
	
}
