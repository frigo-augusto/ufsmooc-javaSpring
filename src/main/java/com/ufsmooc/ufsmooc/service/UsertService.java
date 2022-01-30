package com.ufsmooc.ufsmooc.service;

import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.Usert;
import com.ufsmooc.ufsmooc.domain.repo.UsertRepo;
import com.ufsmooc.ufsmooc.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service @RequiredArgsConstructor @Transactional
public class UsertService implements UsertServiceInterface, UserDetailsService{

    private final UsertRepo usertRepo;
    private final RoleServiceInterface roleRepo;


    @Override
    public Usert save(Usert usert) {
        usert.setPassword(SecurityUtil.encryptPassword(usert.getPassword()));
        System.out.println("opaaa!!!");
        return usertRepo.save(usert);
    }

    @Override
    public void addRole(String email, String roleName) {
        Usert usert = this.findByEmail(email);
        Role role = roleRepo.findByName(roleName);
        usert.setRole(role);
        usertRepo.save(usert);
    }

    @Override
    public Usert findByEmail(String email) {
        return usertRepo.findByEmail(email).orElseThrow(() -> new InvalidParameterException());
    }

    @Override
    public List<Usert> findAll() {
        return usertRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usert user = usertRepo.findByEmail(username).orElseThrow( () -> new InvalidParameterException());
        Role role = user.getRole();
        Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(role.getName()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authority);
    }
}
