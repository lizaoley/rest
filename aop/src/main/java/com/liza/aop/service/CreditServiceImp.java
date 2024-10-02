package com.liza.aop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CreditServiceImp implements BankService{

    @Override
    public String getCredit() {
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Credit was APPROVED";
    }

    @Override
    public String getCredit(boolean x) {

        if(x) {
            throw new RuntimeException("Credit was NOT APPROVED.");
        }

        return getCredit();
    }
}
