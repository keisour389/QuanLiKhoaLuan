package com.java.KhoaLuan.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.repository.UserRepository;

@Service
public class AccountService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	public AccountService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        return new AccountDetails(user.get());
    }

}
