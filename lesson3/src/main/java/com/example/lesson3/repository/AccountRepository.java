package com.example.lesson3.repository;

import com.example.lesson3.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

//    @Query("select a.id from account a where a.username = ?1 and a.password = ?2")
//    public Long getIDByNameAndPass(String name, String pass);
}
