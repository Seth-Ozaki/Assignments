# Create a User class with an __init__ method

# Add a deposit method to the User class that calls on its bank account's instance methods.

# Add a withdrawal method to the User class that calls on its bank account's instance methods.

# Add a display_user_balance method to the User class that displays user's account balance

#  BONUS: Allow a user to have multiple accounts; update methods so the user has to specify which account they are withdrawing or depositing to

#  BONUS: Add a transfer method to the user class that takes an amount and a different User instance,
#         and transfers money from the user's account into another user's account.


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


class User:
    def __init__(self,name, email):
        self.name = name
        self.email = email
        self.bank = [ Account()]
    
    def new_account(self):
        self.bank.append(Account())
    def deposit(self,account_num, amount):
        self.bank[account_num].deposit(amount)
        return self
    
    def withdraw(self,account_num,amount):
        self.bank[account_num].withdraw(amount)
        return self
    
    def transfer(self, account_from, account_to, amount):
        self.bank[account_from].withdraw(amount)
        self.bank[account_to].deposit(amount)
        return f" your transfer of ${amount} from account: {account_from} to account:{account_to} is complete"
    
    def display_account_info(self,account_num):
        return f"user: {user1.name}, your current balance is ${self.bank[account_num].balance} in account {account_num}"
        

user1 = User("john", "johnsmith@gmail.com")
user1.new_account()
print(user1.deposit(0,100).display_account_info(0))
print(user1.withdraw(0,50).display_account_info(0))
print(user1.transfer(0,1,5))

print(user1.deposit(1,50).display_account_info(1))
print(user1.withdraw(1,25).display_account_info(1))