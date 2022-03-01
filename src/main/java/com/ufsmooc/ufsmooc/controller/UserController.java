package com.ufsmooc.ufsmooc.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufsmooc.ufsmooc.domain.dto.UserDto;
import com.ufsmooc.ufsmooc.domain.entities.Role;
import com.ufsmooc.ufsmooc.domain.entities.User;
import com.ufsmooc.ufsmooc.service.RoleServiceInterface;
import com.ufsmooc.ufsmooc.service.UserServiceInterface;
import com.ufsmooc.ufsmooc.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface userService;
    private final RoleServiceInterface roleService;
    private final PasswordEncoder passwordEncoder;

    @RequestMapping(value="/create-user", method = RequestMethod.POST, consumes = "application/JSON")
    public String createUser(@RequestBody UserDto user) throws Exception{
        System.out.println(user);
        if (!user.getPassword().equals(user.getConfirmPassword()) || !UserUtil.isCpfValid(user.getCpf()))
            throw new InvalidParameterException();
        try{
            User userEntity = new User(user, roleService.findByName("ROLE_STUDENT"));
            userService.save(userEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
        System.out.println(userService.findByEmail(user.getEmail()));
        return userService.findAll().toString();
    }

    @RequestMapping(value="/get-users", method = RequestMethod.GET)
    public String getUsers(){
        return userService.findAll().toString();
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
                User user = userService.findByEmail(email);
                List<Role> rolesList = new ArrayList<>(); //change it if switch roles to list in entity
                rolesList.add(user.getRole());
                String access_token = JWT.create()
                        .withSubject(user.getEmail())
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

    @GetMapping("/change-password")
    public void changePassword(@RequestHeader String newPassword){
        User user =  userService.findByEmail(UserUtil.getCurrentUserEmail());
        user.setPassword(passwordEncoder.encode(newPassword));
        userService.save(user);
    }

    public void updateInfo(@RequestBody UserDto userDto){
        //updates the info of the user
    }

    public void transformInTeacher(){
        //sends request to admin to become teacher
    }






}
