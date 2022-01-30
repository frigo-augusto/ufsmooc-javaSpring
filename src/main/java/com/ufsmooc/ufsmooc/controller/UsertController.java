package com.ufsmooc.ufsmooc.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.Usert;
import com.ufsmooc.ufsmooc.domain.repo.UsertRepo;
import com.ufsmooc.ufsmooc.service.RoleService;
import com.ufsmooc.ufsmooc.service.RoleServiceInterface;
import com.ufsmooc.ufsmooc.service.UsertService;
import com.ufsmooc.ufsmooc.service.UsertServiceInterface;
import com.ufsmooc.ufsmooc.util.SecurityUtil;
import com.ufsmooc.ufsmooc.util.UserUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController @RequiredArgsConstructor
public class UsertController {

    private final UsertServiceInterface usertService;
    private final RoleServiceInterface roleService;

    @RequestMapping(value="/create-user", method = RequestMethod.POST, consumes = "application/JSON")
    public String createUser(@RequestBody UserDto user) throws Exception{
        System.out.println(user);
        if (!user.getPassword().equals(user.getConfirmPassword()) || !UserUtil.isCpfValid(user.getCpf()))
            throw new InvalidParameterException();
        try{
            Usert userEntity = new Usert(user, roleService.findByName("ROLE_STUDENT"));
            usertService.save(userEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
        System.out.println(usertService.findByEmail(user.getEmail()));
        return usertService.findAll().toString();
    }

    @RequestMapping(value="/get-users", method = RequestMethod.GET)
    public String getUsers(){
        return usertService.findAll().toString();
    }

    @GetMapping(value = "/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){
        try {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(token);
                String email = decodedJWT.getSubject();
                Usert usert = usertService.findByEmail(email);
                List<Role> rolesList = new ArrayList<>(); //change it if switch roles to list in entity
                rolesList.add(usert.getRole());
                String access_token = JWT.create()
                        .withSubject(usert.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10*60*60*1000))//10 days
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("role", rolesList.stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }
        } catch (Exception e){
            throw new InvalidParameterException();
        }
    }

}
