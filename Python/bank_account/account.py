# Create a BankAccount class with the attributes interest rate and balance

# The class should also have the following methods:

# deposit(self, amount) - increases the account balance by the given amount

# withdraw(self, amount) - decreases the account balance by the given amount if there are sufficient funds;
#  if there is not enough money, print a message 
# "Insufficient funds: Charging a $5 fee" and deduct $5

# display_account_info(self) - print to the console: eg. "Balance: $100"


# yield_interest(self) - increases the account balance by the current balance * the interest rate (as long as the balance is positive)




class Account:

    def __init__(self, int_rate = 0.01, balance = 0.00):
        if int_rate == 0.01:
            self.int_rate = int_rate
        else:
            self.int_rate = int_rate *.01
        self.balance = balance
    
    def deposit(self, amount):
        self.balance = self.balance + amount
        return self
    def withdraw(self, amount):
        if self.balance < amount:
            self.balance = self.balance - 5
            print(f"insufficient funds: charging a $5 fee")
            return self
        else:
            self.balance = self.balance - amount
        return self

    def display_account_info(self):
        return f"your current balance is ${self.balance}"
    def yield_interest(self):
        self.balance  = (self.balance * self.int_rate) + self.balance
        return self


account1 = Account(balance=100)
account2 = Account(1, 100)
# to check for witdrawl penalty
account3 = Account(balance=100)

print(account1.deposit(5).deposit(5).deposit(5).withdraw(15).yield_interest().display_account_info())
print(account2.deposit(1000).deposit(2299).withdraw(600).withdraw(200).withdraw(80).withdraw(29).yield_interest().display_account_info())
# to check for widraw penalty
print(account3.withdraw(101).display_account_info())