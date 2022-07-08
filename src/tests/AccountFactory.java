package tests;

import entities.Account;

// Padrão de projeto

public class AccountFactory {       // classe para instanciar objetos
    
    public static Account createEmptyAccount(){
        return new Account(1L, 0.0);
    }

    public static Account createAccount(double initialBalance){
        return new Account(1L, initialBalance);
    }
}
