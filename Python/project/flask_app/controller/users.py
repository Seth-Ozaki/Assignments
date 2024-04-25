from flask_app import app
from flask import render_template, request, redirect, session, flash
from flask_bcrypt import Bcrypt
from flask_app.model.User import User
from flask_app.model.Pokemon import Pokemon
bcrypt=Bcrypt(app)

@app.route('/log')
def log():
    return render_template('log.html')

@app.route('/clearcookie')
def clearcookie():
    session.clear()
    return redirect ('/')

    
@app.route('/register', methods=['POST'])
def register():
    data = {"email": request.form["email"]}
    user_in_db = User.get_by_email(data)
    if user_in_db:
        flash("Email Already Exists!", "register")
        return redirect('/log')
    if not User.validate(request.form):
        return redirect('/log')
    pw_hash=bcrypt.generate_password_hash(request.form['password'])
    data = {
        "first_name":request.form['first_name'],
        "last_name":request.form['last_name'],
        "email":request.form['email'],
        "password": pw_hash
    }
    User.register(data)
    user_in_db = User.get_by_email(data)
    session['user_id'] = user_in_db.id
    session['name'] = user_in_db.first_name
    return redirect(f"/logged/{session['user_id']}")


@app.route('/login', methods=['POST'])
def login():
    data = {"email": request.form["email"]}
    user_in_db = User.get_by_email(data)
    if not user_in_db:
        flash("Invalid Email", "login")
        return redirect('/log')
    if not bcrypt.check_password_hash(user_in_db.password, request.form['password']):
        flash("Invalid Password", "login")
        return redirect('/log')
    
    session['user_id'] = user_in_db.id
    session['name'] = user_in_db.first_name
    return redirect(f"/logged/{session['user_id']}")

@app.route('/logged/<int:id>')
def logged(id):
    if not 'user_id' in session:
        flash("You must be logged in!", "login")
        return redirect('/')
    return render_template('logged.html', one_user = User.get_user(id), pokemons = Pokemon.get_all_pokemon())

@app.route('/like', methods=['Post'])
def like_pokemon():
    data={
        "user_id" : request.form["user_id"],
        "pokemon_id" : request.form["pokemon_id"]
    }
    User.like_pokemon(data)
    return redirect(f"/logged/{session['user_id']}")

@app.route('/user/<int:id>')
def user(id):
    if not 'user_id' in session:
        flash("You must be logged in!", "login")
        return redirect('/')
    user = User.get_user(id)
    liked_pokemon = User.get_user_liked_pokemon(id)
    return render_template('user.html', user = user, liked_pokemon=liked_pokemon)

