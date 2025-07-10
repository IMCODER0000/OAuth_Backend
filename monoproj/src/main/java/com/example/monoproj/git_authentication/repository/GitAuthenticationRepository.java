package com.example.monoproj.git_authentication.repository;

import java.util.Map;

public interface GitAuthenticationRepository {

    String getLoginLink();

    Map<String, Object> getAccessToken(String code);


    Map<String, Object> getUserInfo(String accessToken);
}
