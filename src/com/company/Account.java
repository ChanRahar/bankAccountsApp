package com.company;

public abstract class Account implements InterestRate {
    //List common properties for savings and checking accounts
    private String name;
    private String ssn;
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    //Constructor to set base properties and initialize the account

    public Account(String name, String ssn, double initDeposit) {
//        System.out.println("Name: " + name);
        this.name = name;
        this.ssn = ssn;
        balance = initDeposit;

        //Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = ssn.substring(ssn.length() - 2, ssn.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }


    //List common methods
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $ " + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $ " + amount);
        printBalance();
    }

    public void transfer(String account, double amount) {
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + account);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your Balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println(
                "Name: " + name +
                        "\nAccount Number: " + accountNumber +
                        "\nBalance: " + balance +
                        "\nRate: " + rate + "%"
        );
    }

}
