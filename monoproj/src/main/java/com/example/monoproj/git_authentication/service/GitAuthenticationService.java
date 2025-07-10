package com.example.monoproj.git_authentication.service;

import java.util.Map;

public interface GitAuthenticationService {

    String getLoginLink();

    Map<String, Object> requestAccessToken(String code);

    Map<String, Object> requestUSerInfo(String accessToken);

}
