package com.example.monoproj.git_authentication.controller;


import com.example.monoproj.git_authentication.service.GitAuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/git-authentication")
@RequiredArgsConstructor
public class GitAuthenticationController {

    private final GitAuthenticationService gitAuthenticationService;

    @GetMapping("/request-login-url")
    public String requestLoginLink() {
        log.info("requestGetLoginLink() called");

        return gitAuthenticationService.getLoginLink();
    }

    @GetMapping("/login")
    public void requestAccessToken(@RequestParam("code") String code,
                                   HttpServletResponse response) throws IOException {
        log.info("requestGetAccessToken() : code = {}", code);
        try {
            Map<String, Object> tokenResponse = gitAuthenticationService.requestAccessToken(code);
            String accessToken = (String) tokenResponse.get("access_token");
            Map<String, Object> userInfo = gitAuthenticationService.requestUSerInfo(accessToken);
            log.info("userInfo : {}", userInfo);



        }catch (Exception e){
            log.info("requestGetAccessToken() : exception = {}", e.getMessage());
        }
    }
}
