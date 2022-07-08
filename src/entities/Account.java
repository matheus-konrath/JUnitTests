package entities;

public class Account {

    public static double DEPOSIT_PERCENT = 0.02;

    private Long id;
    private Double balance;

    public Account(){ 
    }
    
    public Account(Long id, Double balance){
        this.id = id;
        this.balance = balance;
    }

    public Long getId(){
        return id;
    }

    public Double getBalance(){
        return balance;
    }

    void setId(Long id){
        this.id = id;
    }

    public void deposit(double amount){
        if(amount > 0){
        amount -= amount * DEPOSIT_PERCENT;     // desconta a taxa na quantia
        balance += balance + amount;            // acrescenta a quantia ao saldo
        }
    }

    public void WithDraw(double amount){
        if(amount > balance){
            throw new IllegalArgumentException();
        }
        balance = balance - amount;
    }

    public double fullWithDraw(){
        double aux = balance;
        balance = 0.0;
        return aux;
    }
}
