class account:

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


account1 = account(balance=100)
account2 = account(1, 100)
# to check for witdrawl penalty
account3 = account(balance=100)

print(account1.deposit(5).deposit(5).deposit(5).withdraw(15).yield_interest().display_account_info())
print(account2.deposit(1000).deposit(2299).withdraw(600).withdraw(200).withdraw(80).withdraw(29).yield_interest().display_account_info())
# to check for widraw penalty
print(account3.withdraw(101).display_account_info())