# Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].

# Change the last_name of the first student from 'Jordan' to 'Bryant'

# In the sports_directory, change 'Messi' to 'Andres'

# Change the value 20 in z to 30

x = [ [5,2,3], [10,8,9] ] 
students = [
    {'first':  'Michael', 'last' : 'Jordan'},
    {'first' : 'John', 'last' : 'Rosales'},
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]


x[1][0]=15
print(x)

students[0]['last']='Bryant'
print(students)

sports_directory['soccer'][0]= 'Andres'
print(sports_directory)

z[0]['y']=30
print(z)

#-----------------------------------------------------------------------------------------------------------
# Create a function  that, given a list of dictionaries, 
# the function loops through each dictionary in the list and prints each key and the associated value. 
# For example, given the following list: 

students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'},
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'}
]


def iterate_student(elem):
    for dict1 in elem:
        print(f"first_name - {dict1['first_name']}, last_name - {dict1["last_name"]}")

iterate_student(students)

def first(elem):
    for dict2 in elem:
        print(dict2['first_name'])

first(students)

def last(elem):
    for dict3 in elem:
        print(dict3['last_name'])

last(students)

print('------------------------------')

# ----------------------------------------------------------------------------
# Create a function that given a dictionary whose values are all lists, 
# prints the name of each key along with the size of its list, 
# and then prints the associated values within each key's list. 

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def info(elem):
        print(f"{len(elem['locations'])} LOCATIONS")
        for i1 in elem['locations']:
                print(f"{i1}")
        print('----------------------------')
        print(f"{len(elem['instructors'])} INSTRUCTORS")
        for i2 in elem['instructors']:
                print(f"{i2}")


info(dojo)