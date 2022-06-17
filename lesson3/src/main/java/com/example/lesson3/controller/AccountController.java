package com.example.lesson3.controller;


import com.example.lesson3.dto.AccountDto;
import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static javax.xml.bind.DatatypeConverter.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto){
        accountService.createAccount(accountDto);
        return ResponseEntity.ok(accountService.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@RequestBody AccountEntity accountEntity){
        return ResponseEntity.ok(accountService.loginAccount(accountEntity));
//    return ResponseEntity.ok("hello");
    }
    @PostMapping("/{change_password}")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody String password){
//        accountService.changePassword();
        String header = request.getHeader("Authorization");
        return accountService.changePassword(header,password);
    }
}
