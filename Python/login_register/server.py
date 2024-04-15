from flask import Flask, render_template, request, redirect, session, flash
from flask_bcrypt import Bcrypt
from users import User
app = Flask(__name__)
app.secret_key = 'key'
bcrypt=Bcrypt(app)


@app.route('/')
def start():
    User.clear()
    return render_template('home.html')

@app.route('/home')
def home():
    return render_template('home.html')

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
    return redirect(f'/logged/{session['user_id']}')


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

    return redirect(f'/logged/{session['user_id']}')

@app.route('/logged/<int:id>')
def logged(id):
    user = User.get_user(id)
    return render_template('logged.html', one_user = user)

@app.route('/clearcookie')
def clearcookie():
    session.clear()
    return redirect ('/home')


if __name__=='__main__':
    app.run(debug=True)