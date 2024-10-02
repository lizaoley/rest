package com.liza.aop.dao;

import com.liza.aop.Admin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminImpl implements AdminDAO {

    private String name;
    private String password;

    @Override
    public void addAdmin() {
        System.out.println("Add user data from ADMIN: " + getClass());
    }

    public String getName() {
        System.out.println("Get name method: " + getClass());
        return name;
    }

    public void setName(String name) {
        System.out.println("Set name method: " + getClass());
        this.name = name;
    }

    public String getPassword() {
        System.out.println("Get password method: " + getClass());
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Set password method: " + getClass());
        this.password = password;
    }

    @Override
    public List<Admin> findAdmins() {

        List<Admin> admins = new ArrayList<>();

        admins.add(new Admin("Liza", 24));
        admins.add(new Admin("Gosha", 25));
        admins.add(new Admin("Sweta", 50));

        return admins;
    }

    @Override
    public List<Admin> findAdmins(boolean flag) {

        if (flag) {
            throw new RuntimeException("Exception in findAdmins");
        }
        List<Admin> admins = new ArrayList<>();

        admins.add(new Admin("Liza", 24));
        admins.add(new Admin("Gosha", 25));
        admins.add(new Admin("Sweta", 50));

        return admins;
    }

}
