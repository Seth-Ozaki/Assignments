public class AccountTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount bank1 = new BankAccount();
        BankAccount bank2 = new BankAccount();
        BankAccount bank3 = new BankAccount();
        System.out.println(bank1.getAccounts());


        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println(bank1.depositChecking(100));
        System.out.println(bank1.depositSaving(10));
        System.out.println(bank1.getTotal());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        System.out.println(bank1.withdrawChecking(10));
        System.out.println(bank1.withdrawChecking(1));

        System.out.println(bank1.withdrawSaving(10));
        System.out.println(bank1.withdrawSaving(1));


        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println(bank1.getAccounts());
        System.out.println(bank1.getTotal());

        //For Ninja Bonus
        System.out.println(bank1.getAccountNumber());
        System.out.println(bank2.getAccountNumber());

    }
}
