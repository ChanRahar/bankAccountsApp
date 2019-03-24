package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();

//        Checking chkAcc1 = new Checking("Tom Doe", "123135698", 1500);
//
//        Savings savAcc1 = new Savings("Brent Doe", "325656985", 1000);
//
//        chkAcc1.showInfo();
//        System.out.println("--------------------------------");
//        savAcc1.showInfo();
//
//        savAcc1.deposit(500);
//        savAcc1.withdraw(100);
//        savAcc1.transfer("Brokerage", 100);
//        savAcc1.compound();

        //Read csv file
        String file = "NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
//            System.out.println(Arrays.toString(accountHolder));
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
//                System.out.println("Open Savings Account");
                accounts.add(new Savings(name, ssn, initDeposit));
            }
            else if (accountType.equals("Checking")) {
//                System.out.println("Open Checking Account");
                accounts.add(new Checking(name, ssn, initDeposit));
            }
            else {
                System.out.println("Error Reading Data");
            }
        }

        for (Account acc: accounts){
            acc.showInfo();
            System.out.println("---------------------------------");
        }
    }
}
