package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

    @Test
    void depositShouldIcreaseBalanceWhenPositiveAmount(){

        // arrange
        double amount = 200.00;
        double valueExpected = 196.00;
        Account acc = AccountFactory.createEmptyAccount();

        // act
        acc.deposit(amount);

        // assert
        Assertions.assertEquals(valueExpected, acc.getBalance());
    }

    @Test
    void depositShouldDoNothingWhenNegativeAmount() throws Exception{
        
        //arrange
        double amount = -10.00;
        double valueExpected = 0.00;
        Account acc = AccountFactory.createAccount(valueExpected);

        //act
        acc.deposit(amount);

        // assert
        Assertions.assertEquals(valueExpected, acc.getBalance());
    }

    @Test
    void withDrawShouldDiscountWhenPositiveAmount(){

        double amount = 200.00;
        double valueExpected = 300.00;
        Account acc = new Account(3L, 500.00);

        acc.WithDraw(amount);

        Assertions.assertEquals(valueExpected, acc.getBalance());
    }

    @Test
    void fullWithDrawShoulClearBalance(){
        //arrange
        double valueExpected = 0.00;
        double initialBalance = 800.00;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithDraw();

        Assertions.assertTrue(valueExpected == acc.getBalance());
        Assertions.assertEquals(result, initialBalance);

    }

    @Test
    void withDrawShouldDrecrementBalanceWhenAmountIsPositive(){

        double amount = 200.0;
        double valueExpected = 600.00;
        Account acc = AccountFactory.createAccount(800.00);

        acc.WithDraw(amount);

        Assertions.assertEquals(valueExpected, acc.getBalance());
        Assertions.assertFalse(valueExpected == 800);
    }

    @Test
    void whithDrawShouldThrowsExceptionWhenInsufficientBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
           // Account acc = AccountFactory.createAccount(300);
           Account acc = new Account(1L, 300.0);

            acc.WithDraw(600.00);
        });

    }
}
