package com.inkpenbookspublisher.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("register/author")
    public ResponseEntity<AuthenticationResponse> registerAuthor(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerAuthor(request));
    }

    @PostMapping("register/publisher")
    public ResponseEntity<AuthenticationResponse> registerPublisher(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerPublisher(request));
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
