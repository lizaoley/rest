package com.liza.aop.dao;

import com.liza.aop.Admin;

import java.util.List;

public interface AdminDAO {

    void addAdmin();

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);

    List<Admin> findAdmins();

    List<Admin> findAdmins(boolean flag);


}
