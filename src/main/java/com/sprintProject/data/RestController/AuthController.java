

package com.sprintProject.data.RestController;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.jwtconnect.JwtResponse;
import com.sprintProject.data.security.JwtHelper;
import com.sprintProject.data.security.JwtHelper.JwtRequest;

 

@RestController

@RequestMapping("/auth")

public class AuthController {

 

    @Autowired

    private UserDetailsService userDetailsService;

 

    @Autowired

    private AuthenticationManager manager;


//    @Autowired

//    private InvalidatedTokenManager invalidatedTokenManager;

 

    @Autowired

    private JwtHelper helper;

 

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

 

 

    @PostMapping("/login")

    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

 

        this.doAuthenticate(request.getLoginId(), request.getPassword());

 

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLoginId());


        JwtRequest jwtRequest = new JwtRequest();

        jwtRequest.setLoginId(request.getLoginId());

        jwtRequest.setPassword(request.getPassword());


        String token = this.helper.generateToken(userDetails);

 

//        JwtResponse response = JwtResponse.builder()

//                .jwtToken(token)

//                .username(userDetails.getUsername()).build();


        JwtResponse response = new JwtResponse();

        response.setJwtToken(token);

        response.setUsername(userDetails.getUsername());


        return new ResponseEntity<>(response, HttpStatus.OK);



    }

//    

//    @Autowired

//    private TokenBlacklistManager tokenBlacklistManager; // Inject the TokenBlacklistManager

 

    @PostMapping("/logout")

    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {

        // Extract the JWT token from the Authorization header


    	JwtHelper.JWT_TOKEN_VALIDITY = 0;

//        String jwtToken = token.replace("Bearer ", "");

//

//        // Blacklist the token

//        tokenBlacklistManager.blacklistToken(jwtToken);

 

        return ResponseEntity.ok("Logout successful");

    }


//    @PostMapping("/logout")

//    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {

//        // Extract the JWT token from the Authorization header

//        String jwtToken = token.replace("Bearer ", "");

//

//        // Invalidate the token using the InvalidatedTokenManager

//        invalidatedTokenManager.invalidateToken(jwtToken);

//

//        return ResponseEntity.ok("Logout successful");

//    }


 

    private void doAuthenticate(String loginId, String password) {

 

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginId, password);

        try {

            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {

            throw new BadCredentialsException(" Invalid Username or Password  !!");

        }

    }


 

    @ExceptionHandler(BadCredentialsException.class)

    public String exceptionHandler() {

        return "Credentials Invalid !!";

    }

}
