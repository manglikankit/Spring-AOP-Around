package com.manglik.aopdemo.dao;

import com.manglik.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoIml implements AccountDao{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + "Doing my work in an account");
    }

//    @Override
//    public List<Account> findAccounts() {
//        List<Account> accounts = new ArrayList<>();
//        Account ac1 = new Account("John", "Silver");
//        Account ac2 = new Account("Ram", "Gold");
//        Account ac3 = new Account("Lukka", "Iron");
//        accounts.add(ac1);
//        accounts.add(ac2);
//        accounts.add(ac3);
//
//        return accounts;
//    }

    @Override
    public List<Account> findAccounts() {
       return  findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripwire){
        if(tripwire){
            throw new RuntimeException("No soup for you");
        }
        List<Account> accounts = new ArrayList<>();
        Account ac1 = new Account("John", "Silver");
        Account ac2 = new Account("Ram", "Gold");
        Account ac3 = new Account("Lukka", "Iron");
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);

        return accounts;
    }

}
