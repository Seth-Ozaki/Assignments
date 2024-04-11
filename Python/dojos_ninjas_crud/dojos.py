from mysqlconnection import connectToMySQL
from ninjas import Ninja

class Dojo:
    DB = 'dojos_ninjas'
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas=[]

    @staticmethod
    def clear():
        query= "SET SQL_SAFE_UPDATES = 0 "
        connectToMySQL(Dojo.DB).query_db(query)
        query = "ALTER TABLE dojos AUTO_INCREMENT = 1;"
        connectToMySQL(Dojo.DB).query_db(query)
        query= "DELETE FROM dojos WHERE name IS NOT null;"
        connectToMySQL(Dojo.DB).query_db(query)
        query = "ALTER TABLE ninjas AUTO_INCREMENT = 1;"

    @classmethod
    def get_all_dojos(cls):
        query = "SELECT * FROM dojos;"
        results = connectToMySQL('dojos_ninjas').query_db(query)
        dojos = []
        for dojo in results:
            dojos.append( cls(dojo) )
            print(dojos)
        return dojos
    
    @classmethod
    def get_one_dojo(cls, id):
        query = "SELECT * FROM dojos WHERE id = %(id)s;"
        results = connectToMySQL('dojos_ninjas').query_db(query,{"id":int(id)})
        print(results)
        dojos = []
        for dojo in results:
            dojos.append( cls(dojo) )
        return dojos[0]
    
    @classmethod
    def submit_dojo(cls, data):
        query = """INSERT INTO dojos (name)
                    VALUES (%(name)s);"""
        result = connectToMySQL(cls.DB).query_db(query,data)
        return result
    
    @classmethod
    def get_dojo_ninjas( cls , data ):
        print(data)
        query = "SELECT * FROM dojos LEFT JOIN ninjas ON ninjas.dojo_id = dojos.id WHERE dojos.id = %(id)s;"
        
        results = connectToMySQL('dojos_ninjas').query_db( query , data )
        dojo = cls(results[0]) 
        for row_from_db in results:
            
            ninja_data = {
                "id" : row_from_db["id"],
                "first_name" : row_from_db["first_name"],
                "last_name" : row_from_db["last_name"],
                "age" : row_from_db["age"],
                "dojo_id" : row_from_db["dojo_id"],
                "created_at" : row_from_db["ninjas.created_at"],
                "updated_at" : row_from_db["ninjas.updated_at"]
            }
            dojo.ninjas.append( Ninja( ninja_data ) )
        return dojo