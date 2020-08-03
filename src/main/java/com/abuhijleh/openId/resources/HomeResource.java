package com.abuhijleh.openId.resources;

import com.abuhijleh.openId.Models.AuthRequest;
import com.abuhijleh.openId.Models.AuthResponse;
import com.abuhijleh.openId.Services.MyUserDetailsService;
import com.abuhijleh.openId.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {

    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService userDetailsService;

    private final JwtUtils jwtUtils;

    public HomeResource(AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect credentials", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));

    }

    @RequestMapping("/validJwt")
    public ResponseEntity<String> isValid(){
        return ResponseEntity.ok("{\"yes\":\"yes\"}");
    }
}
