package com.manglik.aopdemo.dao;

import com.manglik.aopdemo.Account;

import java.util.List;

public interface AccountDao {
     void addAccount(Account account, boolean vipFlag);

     List<Account> findAccounts();

     List<Account> findAccounts(boolean tripwire);
}
