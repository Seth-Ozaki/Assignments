
from mysqlconnection import connectToMySQL
from datetime import datetime

class User:
    DB = 'users_crud_mod'
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @staticmethod
    def clear():
        query = "ALTER TABLE users AUTO_INCREMENT = 1;"
        connectToMySQL(User.DB).query_db(query)
        query= "SET SQL_SAFE_UPDATES = 0 "
        connectToMySQL(User.DB).query_db(query)
        query= "DELETE FROM users WHERE first_name IS NOT null;"
        connectToMySQL(User.DB).query_db(query)


    
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL('users_crud_mod').query_db(query)
        users = []
        for user in results:
            users.append( cls(user) )
            print(users)
        return users
    

    @classmethod
    def submit(cls, data):
        
        query = """INSERT INTO users (first_name,last_name,email, created_at)
                    VALUES (%(first_name)s,%(last_name)s,%(email)s,NOW());"""
        result = connectToMySQL(cls.DB).query_db(query,data)
        return result
    

    @classmethod
    def get_one(cls, id):
        query = "SELECT * FROM users WHERE id = %(id)s;"
        results = connectToMySQL('users_crud_mod').query_db(query,{"id":int(id)})
        print(results)
        users = []
        for user in results:
            users.append( cls(user) )
            print(users)
        return users[0]
    
    @classmethod
    def delete(cls, id):
        query = "DELETE FROM users WHERE id = %(id)s;"
        result = connectToMySQL(cls.DB).query_db(query,{"id":int(id)})
        return result
    

    @classmethod
    def submit_edit(cls, data):
        query = """UPDATE users
                    SET first_name = %(first_name)s,last_name = %(last_name)s,email = %(email)s
                    WHERE id = %(id)s;"""
        result = connectToMySQL(cls.DB).query_db(query, data)
        return result