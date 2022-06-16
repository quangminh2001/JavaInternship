package com.example.lesson3.service.impl;

import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.repository.AccountRepository;
import com.example.lesson3.service.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void createAccount(AccountEntity accountEntity){
        List<AccountEntity> listAll = findAll();
        int size = listAll.stream().filter(a -> a.getUsername().equals(accountEntity.getUsername())).collect(Collectors.toList()).size();
        if(size > 0){
            System.out.println("Name is similar to name in list");
            return;
        }
        accountRepository.save(accountEntity);
    }
    public String loginAccount(AccountEntity accountEntity){

        List<AccountEntity> listAccounts = findAll();
        int size = (int)listAccounts.stream().filter( a -> a.getUsername().equals(accountEntity.getUsername()) && a.getPassword().equals(accountEntity.getPassword())).count();
        if(size != 0){

        }
        return "";
    }
}
