package com.liza.aop;

import com.liza.aop.dao.AdminDAO;
import com.liza.aop.dao.UserDataDAO;
import com.liza.aop.service.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserDataDAO userDataDAO, AdminDAO adminDAO, BankService bankService) {

        return runner -> {
//          demoTheBeforeAdvice(userDataDAO, adminDAO);
//          runAfterReturningAdvice(adminDAO);
//          runAfterThrowingAdvice(adminDAO);
//          runAfterAdvice(adminDAO);
//          runAroundAdvice(bankService);
            runAroundAdviceWithException(bankService);
        };
    }

    private void runAroundAdviceWithException(BankService bankService) {
        System.out.println("Main program start!");

        boolean x = true;
        String m = bankService.getCredit(x);
        System.out.println("Decision: " + m);

        System.out.println("Main program end!");
    }

    private void runAroundAdvice(BankService bankService) {
        System.out.println("Main program start!");

        String m = bankService.getCredit();
        System.out.println("Decision: " + m);

        System.out.println("Main program end!");
    }

    private void runAfterAdvice(AdminDAO adminDAO) {
        List<Admin> admins = null;
        try {
            boolean flag = false;
            admins = adminDAO.findAdmins(flag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("No exception in main");
    }

    private void runAfterThrowingAdvice(AdminDAO adminDAO) {
        List<Admin> admins = null;
        try {
            boolean flag = true;
            admins = adminDAO.findAdmins(flag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void runAfterReturningAdvice(AdminDAO adminDAO) {

        adminDAO.findAdmins().forEach(System.out::println);

    }

    private static void demoTheBeforeAdvice(UserDataDAO userDataDAO, AdminDAO adminDAO) {

        userDataDAO.addUserData();
        adminDAO.addAdmin();
        adminDAO.setName("Liza");
        adminDAO.setPassword("1233445");
        String name = adminDAO.getName();
        String password = adminDAO.getPassword();
    }

}
