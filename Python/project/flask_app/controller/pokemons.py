from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.model.Pokemon import Pokemon


@app.route('/')
def index():
    return render_template('index.html', pokemons = Pokemon.get_all_pokemon())

@app.route('/pokemon/<name>')
def get_pokemon(name):
    pokemon=Pokemon.get_pokemon({"name":name})
    return render_template('pokedata.html', pokemon=pokemon)

# hello