package com.company;

public interface InterestRate {
    //Write a method that returns the base rate
    default double getBaseRate() {
        return 2.5;
    }

}
