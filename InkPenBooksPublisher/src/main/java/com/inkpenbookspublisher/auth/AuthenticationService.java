package com.inkpenbookspublisher.auth;

import com.inkpenbookspublisher.config.JwtService;
import com.inkpenbookspublisher.model.Roles;
import com.inkpenbookspublisher.model.User;
import com.inkpenbookspublisher.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    private User.UserBuilder register(RegisterRequest request){
        return User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()));
    }
    public AuthenticationResponse registerAuthor(RegisterRequest request) {
        var user = register(request)
                .roles(Roles.AUTHOR)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
    }

    public AuthenticationResponse registerPublisher(RegisterRequest request) {
        var user =register(request)
                .roles(Roles.ADMIN)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         request.getEmail(),
                         request.getPassword()
                 )
         );
         var user = userRepository.findByEmail(request.getEmail())
                 .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
