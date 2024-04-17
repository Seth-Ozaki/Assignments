from belt_app.config.mysqlconnection import connectToMySQL
from flask import flash
from belt_app.model.users import User


class Trip:
    DB = 'belt'
    def __init__( self , data ):
        self.id = data['id']
        self.destination = data['destination']
        self.start_date = data['start_date']
        self.end_date = data['end_date']
        self.itinerary = data['itinerary']
        self.user_id = data['user_id']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user=None


    @staticmethod
    def clear():
        query= "SET SQL_SAFE_UPDATES = 0 "
        connectToMySQL(Trip.DB).query_db(query)
        query = "ALTER TABLE trips AUTO_INCREMENT = 0;"
        connectToMySQL(Trip.DB).query_db(query)
        query= "DELETE FROM trips WHERE destination IS NOT null;"
        connectToMySQL(Trip.DB).query_db(query)


    @staticmethod
    def validate_trip(trip):
        is_valid = True
        if len(trip['destination']) < 1:
            flash("There must be a trip destination", "add_trip")
            is_valid = False
        if (trip['start_date'] == ''):
            flash("there must be a start date", "add_trip")
            is_valid = False
        if (trip['end_date'] == ''):
            flash("there must be a end date", "add_trip")
            is_valid = False
        if len(trip['itinerary']) < 1:
            flash("There must be an itinerary", "add_trip")
        if len(trip['itinerary']) > 50:
            flash("There must be an itinerary", "add_trip")
            is_valid = False
        
        return is_valid

    @classmethod
    def add_trip(cls, data):
        query = """INSERT INTO trips (destination, start_date, end_date, itinerary, created_at, updated_at,  user_id)
                VALUES (%(destination)s,%(start_date)s,%(end_date)s,%(itinerary)s,NOW(),NOW(),%(user_id)s);"""
        result = connectToMySQL(Trip.DB).query_db(query,data)
        print(result)
        return result

    @classmethod
    def get_trip(cls, id):
        query = "SELECT * FROM trips JOIN users ON users.id = trips.user_id WHERE trips.id = %(id)s"
        results = connectToMySQL(User.DB).query_db(query,{"id":id})
        trip = cls(results[0])
        temp_user = {
                "id" : results[0]["users.id"],
                "first_name" : results[0]["first_name"],
                "last_name" : results[0]["last_name"],
                "email" : results[0]["email"],
                "password" : results[0]["password"],
                "created_at" : results[0]["users.created_at"],
                "updated_at" : results[0]["users.updated_at"]
            }
        trip.user = User(temp_user)
        return trip
    
    @classmethod
    def get_users_trips( cls ):
        query = "SELECT * FROM trips JOIN users ON users.id = trips.user_id"
        results = connectToMySQL(Trip.DB).query_db( query )

        trips = []
        for trip in results:
            new_recipe = cls(trip)
            temp_user = {
                "id" : trip["users.id"],
                "first_name" : trip["first_name"],
                "last_name" : trip["last_name"],
                "email" : trip["email"],
                "password" : trip["password"],
                "created_at" : trip["users.created_at"],
                "updated_at" : trip["users.updated_at"]
            }
            new_recipe.user = User(temp_user)
            trips.append( new_recipe )
        return trips
    
    @classmethod
    def delete_trip(cls, id):
        query = "DELETE FROM trips WHERE id = %(id)s;"
        result = connectToMySQL(Trip.DB).query_db(query,{"id":int(id)})
        return result
    
    @classmethod
    def submit_edit(cls, data):
        query = """UPDATE trips
                    SET destination = %(destination)s,start_date = %(start_date)s,end_date = %(end_date)s,itinerary = %(itinerary)s,updated_at = NOW()
                    WHERE id = %(id)s;"""
        result = connectToMySQL(Trip.DB).query_db(query, data)
        return result