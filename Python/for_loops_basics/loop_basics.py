# Create a Python file that performs the following tasks.

# Basic - 
        #  Print all integers from 0 to 150.

# Multiples of Five - 
#           Print all the multiples of 5 from 5 to 1,000

# Counting, the Dojo Way - 
#           Print integers 1 to 100. If divisible by 5, print "Coding" instead. 
#           If divisible by 10, print "Coding Dojo".

# Whoa. That Sucker's Huge - 
#           Add odd integers from 0 to 500,000, and print the final sum.

# Countdown by Fours - 
#           Print positive numbers starting at 2018, counting down by fours.
# Flexible Counter - 
#           Set three variables: lowNum, highNum, mult. 
#           Starting at lowNum and going through highNum, print only the integers that are a multiple of mult. 
#           For example, if lowNum=2, highNum=9, and mult=3, the loop should print 3, 6, 9 (on successive lines)

for i in range(151):
    print(i)
#---------------------
for j in range(5, 1001):
    if j%5==0:
        print(j)
#---------------------
for k in range(101):
    if k%5==0:
        print("Coding Dojo")
    else:
        print(k)
#---------------------
sum = 0
for l in range(500001):
    if l%2==1:
        sum+=l

print(sum)
#---------------------
for m in range(2018, 0, -4):
    print(m)
#---------------------
for p in range(2, 10):
    if p%3==0:
        print(p)