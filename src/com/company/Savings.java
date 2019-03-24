package com.company;

public class Savings extends Account {
    //List properties specific to a savings account
    private static int safetyDepositBoxId = 100;
    private int safetyDepositBoxKey;

    //Constructor to initialize savings account properties

    public Savings(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        accountNumber = 1 + accountNumber;
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxId++;
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    @Override
    public void setRate() {
        rate = getBaseRate() -.25;
    }

    //List any methods specific to the savings account
    public void showInfo(){
        super.showInfo();
        System.out.println("Account Type: Savings");
        System.out.println(
                "Your Savings Account Features" +
                        "\n Safety Deposit Box ID: " + safetyDepositBoxId +
                        "\n Safety Deposite Box Key: " + safetyDepositBoxKey
        );
    }
}
