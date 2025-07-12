package com.anfeespi.apigames.controller;

import com.anfeespi.apigames.config.security.TokenService;
import com.anfeespi.apigames.dto.Response;
import com.anfeespi.apigames.dto.UserDTO;
import com.anfeespi.apigames.model.User;
import com.anfeespi.apigames.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Response> register(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(new Response(userService.createUser(user) + ""));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(userDTO.username() + " " + userDTO.password());
        Authentication authToken = new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password());
        var authUser = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((User) authUser.getPrincipal());
        return ResponseEntity.ok(new Response("Token: " + tokenJWT));
    }
}
