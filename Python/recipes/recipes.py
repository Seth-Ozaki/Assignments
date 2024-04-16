from mysqlconnection import connectToMySQL
from flask import flash
from users import User


class Recipe:
    DB = 'recipes'
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.under = bool(data['under'])
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_made = data['date_made']
        self.user_id = data['user_id']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user=None

    @staticmethod
    def clear():
        query= "SET SQL_SAFE_UPDATES = 0 "
        connectToMySQL(Recipe.DB).query_db(query)
        query = "ALTER TABLE recipes AUTO_INCREMENT = 0;"
        connectToMySQL(Recipe.DB).query_db(query)
        query= "DELETE FROM recipes WHERE name IS NOT null;"
        connectToMySQL(Recipe.DB).query_db(query)
        

    @classmethod
    def add_recipe(cls, data):
        query = """INSERT INTO recipes (name, under, description, instructions, date_made, user_id)
                VALUES (%(name)s,%(under)s,%(description)s,%(instructions)s,%(date_made)s,%(user_id)s);"""
        result = connectToMySQL(Recipe.DB).query_db(query,data)
        return result
    
    @classmethod
    def get_users_recipes( cls ):
        query = "SELECT * FROM recipes JOIN users ON users.id = recipes.user_id"
        
        results = connectToMySQL(Recipe.DB).query_db( query )
        # user = cls(results[0])
        recipes = []
        for recipe in results:
            new_recipe = cls(recipe)
            temp_user = {
                "id" : recipe["users.id"],
                "first_name" : recipe["first_name"],
                "last_name" : recipe["last_name"],
                "email" : recipe["email"],
                "password" : recipe["password"],
                "created_at" : recipe["users.created_at"],
                "updated_at" : recipe["users.updated_at"]
            }
            new_recipe.user = User(temp_user)
            recipes.append( new_recipe )
        return recipes