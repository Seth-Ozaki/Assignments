from flask_app import app
from flask_app.controller import pokemons
from flask_app.model.Pokemon import Pokemon
from flask_app.controller import users
from flask_app.model.User import User

# Pokemon.clear()
# User.clear()
Pokemon.load()

if __name__=='__main__':
    app.run(debug=True)