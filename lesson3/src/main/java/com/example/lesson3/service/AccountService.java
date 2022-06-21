package com.example.lesson3.service;

import com.example.lesson3.dto.AccountRequest;
import com.example.lesson3.dto.AccountResponse;
import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.entity.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService  {
    List<AccountEntity> findAll();
    ResponseEntity<?> createAccount(AccountRequest accountRequest);
    ResponseEntity<?> loginAccount(AccountRequest accountRequest);
//    void changePassword(String str);
    ResponseEntity<ResponseObject> changePassword(String stringRandom,String password);
}
