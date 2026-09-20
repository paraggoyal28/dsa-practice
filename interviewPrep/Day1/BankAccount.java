
public class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount() {
        this.balance = 0;
    }

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds");
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
        } else {
            this.balance -= amount;
        }
    }

    public void display() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Holder Name: " + this.holderName);
        System.out.println("Balance: " + this.balance);
    }

    public static void main(String args[]) {
        BankAccount a1 = new BankAccount("SB001", "Aman", 5000);

        a1.deposit(2000);
        a1.withdraw(10000);
        a1.display();
    }   
}
