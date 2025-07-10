package com.example.monoproj.git_authentication.controller.request_form;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccessTokenRequestForm {
    String code;

}
