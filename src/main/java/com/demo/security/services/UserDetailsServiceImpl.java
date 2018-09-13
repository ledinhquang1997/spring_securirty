package com.demo.security.services;

import com.demo.security.domain.Account;
import com.demo.security.domain.Role;
import com.demo.security.repository.AccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Account> accountCredentials = accountRepository.findById(username);
        if (!accountCredentials.isPresent()) {
            throw new RuntimeException();
        }
        Account account= accountCredentials.get();
        return new User(account.getUsername(),account.getEncrytedPassword(),getAuthorities(account.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        return roles
                .stream()
                .map(role -> {
                    System.out.println(role.getRole());
                    return new SimpleGrantedAuthority(role.getRole());
                })
                .collect(Collectors.toList());
    }
}

