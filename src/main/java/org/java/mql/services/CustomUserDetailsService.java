package org.java.mql.services;

import org.java.mql.models.User;
import org.java.mql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User Not found");
		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername()).password(user.getPassword()).roles("user")
				.build();
		return userDetails;
	}

}
