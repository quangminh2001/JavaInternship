package com.example.lesson3.controller;


import com.example.lesson3.dto.AccountRequest;
import com.example.lesson3.dto.AccountResponse;
import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<?> createAccount(@RequestBody @Valid AccountRequest accountRequest){
//        accountService.createAccount(accountRequest);
        return accountService.createAccount(accountRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@RequestBody @Valid AccountRequest accountRequest){
        return accountService.loginAccount(accountRequest);
    }
    @PostMapping("/{change_password}")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody String password){
        String header = request.getHeader("Authorization");
        return accountService.changePassword(header,password);
    }
}
