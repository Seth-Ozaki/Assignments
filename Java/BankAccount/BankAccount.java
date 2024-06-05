import java.util.Random;
import java.util.ArrayList;
public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingBalance;

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances


    //Ninja Bonus 1: Add the following class attribute: account number. The type is up to you, can be a String or a Long or another type.
    private String accountNumber;

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(){
        this.checkingBalance = 0;
        this.savingBalance = 0;
        accounts++;

        // Ninja Bonus 3: In the constructor, call the private method from below so that each user has a random ten-digit account.
        this.accountNumber = generateAccountNumber();
    }

    // Ninja Bonus 2: Create a private method that returns a random ten digit account number.
    private String generateAccountNumber(){
        Random rng = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            numbers.add(rng.nextInt(9));
        }
        String output = new String();
        for(int number:numbers){
            output = output+number;
        }
        return output;
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getChecking(){
        return checkingBalance;
    }
    public double getSaving(){
        return savingBalance;
    }
    public double getAccounts(){
        return accounts;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public String depositChecking(double amount){
        totalMoney+=amount;
        checkingBalance += amount;
        String output = String.format("Deposit of %s is successful checking balance $%s", amount, checkingBalance);
        return output;
    }

    public String depositSaving(double amount){
        totalMoney+=amount;
        savingBalance += amount;
        String output = String.format("Deposit of %s is successful saving balance $%s", amount, savingBalance);
        return output;
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public String withdrawChecking(double amount){
        if(amount>checkingBalance){
            return "Insufficient Funds";
        }
        totalMoney-=amount;
        checkingBalance-=amount;
        String output = String.format("Withdrawal of $%s success. Remaining balance: $%s", amount, checkingBalance);
        return output;
    }

    public String withdrawSaving(double amount){
        if(amount>savingBalance){
            return "Insufficient Funds";
        }
        totalMoney-=amount;
        savingBalance-=amount;
        String output = String.format("Withdrawal of $%s success. Remaining balance: $%s", amount, savingBalance);
        return output;
    }



    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public String getTotal(){
        String output = String.format("Total money: $%s", totalMoney);
        return output;
    }




}
