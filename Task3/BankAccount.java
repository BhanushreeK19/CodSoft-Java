class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            return true;
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}