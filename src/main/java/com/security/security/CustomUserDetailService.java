package com.security.security;

import com.security.entity.Users;
import com.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String usernameorEmail) throws UsernameNotFoundException{
        Users users = userRepository.findByUsernameOrEmail(usernameorEmail, usernameorEmail)
                .orElseThrow(()-> new UsernameNotFoundException("User not exists by Username or Email"));
        Set<GrantedAuthority> authorities = users.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new User(usernameorEmail,users.getPassword(),authorities);
    }
    
}
