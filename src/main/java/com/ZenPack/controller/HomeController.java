package com.ZenPack.controller;

import com.ZenPack.model.JwtRequest;
import com.ZenPack.model.JwtResponse;
import com.ZenPack.service.Services.UserService;
import com.ZenPack.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private JWTUtility utility;

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager manager;

    @GetMapping("/")
    public String home() {
        return "Hello";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = service.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                utility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
