class account:

    def __init__(self, int_rate = 0.01, balance = 0.00):
        self.int_rate = int_rate *.01
        self.balance = balance
    
    def deposit(self, amount):
        self.balance = self.balance + amount
        return f"your new balance is ${self.balance}"
    def withdraw(self, amount):
        if self.balance < amount:
            self.balance = self.balance - 5
            return f"insufficient funds: charging a $5 fee"
        else:
            self.balance = self.balance - amount
        return f"your new balance is ${self.balance}"
    def display_account_info(self):
        return f"your current balance is ${self.balance}"
    def yield_interest(self):
        self.balance  = (self.balance * self.int_rate) + self.balance
        return f"with your {self.int_rate / self.int_rate}% interest added ${self.balance * self.int_rate} worth of interest making your balance ${self.balance}"

account1 = account(1, 100.00)

print(account1.deposit(5))
print(account1.withdraw(5))
print(account1.display_account_info())
print(account1.yield_interest())


# this checks to see if there is enough money
# print(account1.withdraw(200))
# print(account1.display_account_info())