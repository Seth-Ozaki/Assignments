from belt_app import app
from flask import render_template, request, redirect, session, flash
from flask_bcrypt import Bcrypt
from belt_app.model.users import User
bcrypt=Bcrypt(app)

@app.route('/')
def start():
    # Trip.clear()
    # User.clear()
    return render_template('home.html')


@app.route('/home')
def home():
    return render_template('home.html')

@app.route('/clearcookie')
def clearcookie():
    session.clear()
    return redirect ('/home')

@app.route('/register', methods=['POST'])
def register():
    data = {"email": request.form["email"]}
    user_in_db = User.get_by_email(data)
    if user_in_db:
        flash("Email Already Exists!", "register")
        return redirect('/home')
    if not User.validate(request.form):
        return redirect('/home')
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
        return redirect('/home')
    if not bcrypt.check_password_hash(user_in_db.password, request.form['password']):
        flash("Invalid Password", "login")
        return redirect('/home')
    
    session['user_id'] = user_in_db.id
    session['name'] = user_in_db.first_name
    return redirect(f"/logged/{session['user_id']}")

