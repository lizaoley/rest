package com.liza.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Manager {

    @Before("MyPointcutEx.pointcutForMethods()")
    public void beforeManager() {
        System.out.println("    2 Before addUserData");
    }
}
