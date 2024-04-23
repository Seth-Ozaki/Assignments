from flask_app import app
from flask_app.controller import pokemons
from flask_app.model.Pokemon import Pokemon

# Pokemon.clear()
Pokemon.load()

if __name__=='__main__':
    app.run(debug=True)