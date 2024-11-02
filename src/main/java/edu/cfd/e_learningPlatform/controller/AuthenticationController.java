package edu.cfd.e_learningPlatform.controller;

import edu.cfd.e_learningPlatform.dto.request.*;
import edu.cfd.e_learningPlatform.dto.response.*;
import edu.cfd.e_learningPlatform.service.EmailService;
import edu.cfd.e_learningPlatform.service.Impl.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
public class AuthenticationController {
    AuthenticationService authenticationService;
    EmailService emailService;
    PasswordEncoder passwordEncoder;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/forgot-password")
    ApiResponse<EmailResponse> forgotPassword(@RequestBody EmailRequest request) throws MessagingException {
        String otp = emailService.generateOTP(request.getEmail());
        emailService.sendOTPEmail(request.getEmail(), otp);
        return ApiResponse.<EmailResponse>builder()
                .result(EmailResponse.builder()
                        .hashedOtp(passwordEncoder.encode(otp))
                        .creationTime(LocalDateTime.now())
                        .build())
                .build();
    }

    @PostMapping("/verify-otp")
    public ApiResponse<VerifyOtpResponse> verifyOtp(@RequestBody VerifyOtpRequest request) {
        LocalDateTime expirationTime = LocalDateTime.now();
        boolean isOtpValid = emailService.verifyOTP(request.getOtp(), request.getHashedOtp(), request.getCreationTime(), expirationTime);
        return ApiResponse.<VerifyOtpResponse>builder()
                .result(VerifyOtpResponse.builder()
                        .valid(isOtpValid)
                        .build())
                .build();
    }


}
