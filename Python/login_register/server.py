from flask import Flask, render_template, request, redirect, session
from users import User
app = Flask(__name__)
app.secret_key = 'key'

@app.route('/')
def start():
    return render_template('home.html')

@app.route('/home')
def home():
    return render_template('home.html')

@app.route('/register', methods=['POST'])
def register():
    return redirect('/logged')


@app.route('/login', methods=['POST'])
def login():
    return redirect('/logged')

@app.route('/logged')
def logged():
    return render_template('logged.html')


if __name__=='__main__':
    app.run(debug=True)