package com.liza.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDataImpl implements UserDataDAO{

    @Override
    public void addUserData() {
        System.out.println("Add user data from USER: " + getClass());
    }
}
