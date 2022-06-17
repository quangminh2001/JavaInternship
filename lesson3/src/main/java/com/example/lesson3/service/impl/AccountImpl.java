package com.example.lesson3.service.impl;

import com.example.lesson3.dto.AccountDto;
import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.Singleton;
import com.example.lesson3.repository.AccountRepository;
import com.example.lesson3.service.AccountService;
import com.example.lesson3.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
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
    public void createAccount(AccountDto accountDto){
        List<AccountEntity> listAll = findAll();
        int size = listAll.stream().filter(a -> a.getUsername().equals(accountDto.getUsername())).collect(Collectors.toList()).size();
        if(size > 0){
            System.out.println("Name is similar to name in list");
            return;
        }
        // bcryt chuẩn hóa password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        accountDto.setPassword(encoder.encode(accountDto.getPassword()));
        // trả về account
        AccountEntity accountEntity2 = new AccountEntity();
        accountEntity2.setPassword(accountDto.getPassword());
        accountEntity2.setUsername(accountDto.getUsername());
        accountRepository.save(accountEntity2);
    }
    //random ký tự
    public char randomCharacter(){
        int rand = new Random().nextInt(52);
        char start = (rand < 26) ? 'A' : 'a';
        return (char) (start + rand % 26);
    }

    Singleton singleton = new Singleton();
    public String loginAccount(AccountEntity accountEntity){
        List<AccountEntity> listAccounts = findAll();
        int size = (int)listAccounts.stream().filter( a -> a.getUsername().equals(accountEntity.getUsername()) && a.getPassword().equals(accountEntity.getPassword())).count();
        // tạo ra một chuỗi 30 ký tự
        String random = "";
        // kiểm tra có tài khoản password k?
        if(size != 0){
            for(int i = 0; i < 30; i++){
                random += "" + randomCharacter();
            }
            // lấy account có username và password ra
            AccountEntity account = listAccounts.stream()
                    .filter(a -> a.getUsername().equals(accountEntity.getUsername()) && a.getPassword().equals(accountEntity.getPassword()))
                    .findAny()
                    .orElse(null);
            // lưu chuỗi String trong hashmap và có value bằng id của account longin
            HashMap<String,Integer> singletonHashMap = new HashMap<>();
            singletonHashMap.put(random,Integer.parseInt(account.getId() +""));
            singleton.setSingletonHashmap(singletonHashMap);
        }
        return random;
    }
    public ResponseEntity<ResponseObject> changePassword(String stringRandom,String password){
        // chuẩn hóa chuỗi theo bcrypt
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String pw = encoder.encode(password);
        // lấy ra id của account
        int accountid = singleton.getSingletonHashmap().get(stringRandom);
        // lấy ra account bằng id
        AccountEntity account = findAll().stream()
                .filter(a -> a.getId() == accountid)
                .findAny()
                .orElse(null);
        // gán mật khâu mới vào account
        account.setPassword(pw);
        //lưu update bản ghi vào trong db
        accountRepository.save(account);
        //Chuyển entity về dto để hiển thị
        AccountDto accountDto = Convert.entityToAccountDto(new AccountDto(),account);
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("Oke","Successful",accountDto)
        );
    }
}
