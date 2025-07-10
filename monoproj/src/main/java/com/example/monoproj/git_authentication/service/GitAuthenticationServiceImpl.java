package com.example.monoproj.git_authentication.service;


import com.example.monoproj.git_authentication.repository.GitAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitAuthenticationServiceImpl implements GitAuthenticationService {

    private final GitAuthenticationRepository gitAuthenticationRepository;

    @Override
    public String getLoginLink() {
        return gitAuthenticationRepository.getLoginLink();
    }

    @Override
    public Map<String, Object> requestAccessToken(String code) {
        return this.gitAuthenticationRepository.getAccessToken(code);
    }

    @Override
    public Map<String, Object> requestUSerInfo(String accessToken) {
        return gitAuthenticationRepository.getUserInfo(accessToken);
    }
}
