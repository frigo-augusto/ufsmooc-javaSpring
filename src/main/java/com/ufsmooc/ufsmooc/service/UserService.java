package com.ufsmooc.ufsmooc.service;

import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.User;
import com.ufsmooc.ufsmooc.domain.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service @RequiredArgsConstructor @Transactional
public class UserService implements UserServiceInterface, UserDetailsService{

    private final UserRepo userRepo;
    private final RoleServiceInterface roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void addRole(String email, String roleName) {
        User user = this.findByEmail(email);
        Role role = roleRepo.findByName(roleName);
        user.setRole(role);
        userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(InvalidParameterException :: new);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("o usuario eh" + username);
        User user = userRepo.findByEmail(username).orElseThrow(InvalidParameterException::new);
        Role role = user.getRole();
        Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(role.getName()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authority);
    }

}
