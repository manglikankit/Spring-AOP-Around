package com.manglik.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoIml implements MembershipDao{

    @Override
    public void addAccount() {
        System.out.println(getClass() + "Doing my work in an Membership account");
    }
}
