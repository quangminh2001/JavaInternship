package com.example.lesson3.controller;


import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> createAccount(@RequestBody AccountEntity accountEntity){
//        System.out.println(accountEntity.toString());
//        String pw = accountEntity.getPassword();
//        MessageDigest md = null;
//        try {
//            md = MessageDigest.getInstance("MD5");
//            md.update(pw.getBytes());
//            byte[] digest = md.digest();
//            String myHash = printHexBinary(digest).toUpperCase();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        System.out.println(pw);
//        accountService.createAccount(accountEntity);
        return ResponseEntity.ok(accountService.findAll());
    }
    @PostMapping("/{login}")
    public ResponseEntity<?> loginAccount(@RequestBody AccountEntity accountEntity){

        return ResponseEntity.ok(accountService.loginAccount(accountEntity));
    }
}
