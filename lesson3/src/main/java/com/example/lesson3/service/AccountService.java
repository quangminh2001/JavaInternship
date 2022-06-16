package com.example.lesson3.service;

import com.example.lesson3.entity.AccountEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService  {
    List<AccountEntity> findAll();
    void createAccount(AccountEntity accountEntity);
    String loginAccount(AccountEntity accountEntity);
}
