from flask import Flask, render_template, request, redirect, session
from user import User
app = Flask(__name__)
app.secret_key='placeholder key'
User.clear()

@app.route('/')
def start():
    return render_template('add_user.html')


@app.route('/all')
def all():
    users = User.get_all()
    return render_template("all_user.html", all_users = users)

@app.route('/submit', methods=['POST'])
def submit():
    User.submit(request.form)
    return redirect('/all')


if __name__=='__main__':
    app.run(debug=True)