import requests
from pprint import pprint
from flask_app.config.mysqlconnection import connectToMySQL

base = 'https://pokeapi.co/api/v2/pokemon?limit=151'
pokemon_url = 'https://pokeapi.co/api/v2/pokemon/'


class Pokemon:
    DB = 'pokemon'
    def __init__(self, data):
        self.name = data['name']
        self.height = data['height']
        self.image = data['image']
        self.hp = data['hp']
        self.attack = data['attack']
        self.defense = data['defense']
        self.sp_attack = data['sp_attack']
        self.sp_defense = data['sp_defense']
        self.speed = data['speed']
        self.weight = data['weight']
        self.type1 = data['type1']
        self.type2 = data['type2']
        self.game_appearance = data['game_appearance']
        self.first_ability = data['first_ability']

        


    
    @staticmethod
    def clear():
        query= "SET SQL_SAFE_UPDATES = 0 "
        connectToMySQL(Pokemon.DB).query_db(query)
        query = "ALTER TABLE pokemons AUTO_INCREMENT = 1;"
        connectToMySQL(Pokemon.DB).query_db(query)
        query= "DELETE FROM pokemons WHERE name IS NOT null;"
        connectToMySQL(Pokemon.DB).query_db(query)



    @staticmethod
    def load():
        query = "SELECT * FROM pokemons"
        result = connectToMySQL(Pokemon.DB).query_db(query)
        if len(result) == 0:
            data = requests.get(base).json()
            for pokemon in data['results']:
                print(pokemon)
                this_pokemon = requests.get(pokemon_url+pokemon['name']).json()
                if len(this_pokemon['types'])<2:
                    type2 = None
                else:
                    type2 = this_pokemon['types'][1]['type']['name']

                pokemon_info={
                        'name' : pokemon['name'],
                        'height' : this_pokemon['height'],
                        'image' : this_pokemon['sprites']['front_default'],
                        'hp' : this_pokemon['stats'][0]['base_stat'],
                        'attack' : this_pokemon['stats'][1]['base_stat'],
                        'defense' : this_pokemon['stats'][2]['base_stat'],
                        'sp_attack' : this_pokemon['stats'][3]['base_stat'],
                        'sp_defense' : this_pokemon['stats'][4]['base_stat'],
                        'speed' : this_pokemon['stats'][5]['base_stat'],
                        'weight' : this_pokemon['weight'],
                        'type1' : this_pokemon['types'][0]['type']['name'],
                        'type2' : type2,
                        'game_appearance' : this_pokemon['game_indices'][0]['version']['name'],
                        'first_ability' : this_pokemon['abilities'][0]['ability']['name'],
                    }
                query = """INSERT INTO pokemons (name, height, image, hp, attack, defense, sp_attack, sp_defense, speed, weight, type1, type2, game_appearance, first_ability)
                        VALUES (%(name)s, %(height)s, %(image)s, %(hp)s, %(attack)s, %(defense)s, %(sp_attack)s, %(sp_defense)s, %(speed)s, %(weight)s, %(type1)s,%(type2)s,%(game_appearance)s,%(first_ability)s);"""
                result = connectToMySQL(Pokemon.DB).query_db(query,pokemon_info)



    @classmethod
    def get_all_pokemon(cls):
        query = "SELECT * FROM pokemons"
        results = connectToMySQL(Pokemon.DB).query_db(query)
        pokemons = []
        for pokemon in results:
            pokemons.append( Pokemon(pokemon) )
        return pokemons
    
    @classmethod
    def get_pokemon(cls, name):
        query = "SELECT * FROM pokemons WHERE name = %(name)s"
        results = connectToMySQL(Pokemon.DB).query_db(query,name)
        print(results)
        pokemons=[]
        for pokemon in results:
            pokemons.append(Pokemon(pokemon))
        return pokemons[0]
    