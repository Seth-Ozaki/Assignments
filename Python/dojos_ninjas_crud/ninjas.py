from mysqlconnection import connectToMySQL

class Ninja:
    DB = 'dojos_ninjas'
    def __init__( self , db_data ):
        self.id = db_data['id']
        self.first_name = db_data['first_name']
        self.last_name = db_data['last_name']
        self.age = db_data['age']
        self.dojo_id = db_data['dojo_id']
        self.created_at = db_data['created_at']
        self.updated_at = db_data['updated_at']

    @staticmethod
    def clear():
        query= "SET SQL_SAFE_UPDATES = 0 "
        connectToMySQL(Ninja.DB).query_db(query)
        query = "ALTER TABLE ninjas AUTO_INCREMENT = 1;"
        connectToMySQL(Ninja.DB).query_db(query)
        query= "DELETE FROM ninjas WHERE first_name IS NOT null;"
        connectToMySQL(Ninja.DB).query_db(query)

    @classmethod
    def get_all_ninjas(cls):
        query = "SELECT * FROM ninjas;"
        results = connectToMySQL('dojos_ninjas').query_db(query)
        ninjas = []
        for ninja in results:
            ninjas.append( cls(ninja) )
        return ninjas
    
    @classmethod
    def submit_ninja(cls, data):
        query = """INSERT INTO ninjas (first_name, last_name, age, dojo_id)
                    VALUES (%(first_name)s,%(last_name)s,%(age)s,%(dojo_id)s);"""
        result = connectToMySQL(cls.DB).query_db(query,data)
        return result