from flask import  render_template, request, redirect, session
from flask_app.models.user import User
from flask_app import app

@app.route('/')
def start():
    User.clear()
    return render_template('all_user.html')

@app.route('/create')
def create():
    return render_template('add_user.html')


@app.route('/all')
def all():
    users = User.get_all()
    return render_template("all_user.html", all_users = users)

@app.route('/submit', methods=['POST'])
def submit():
    User.submit(request.form)
    return redirect('/all')

@app.route('/user/<int:id>')
def user(id):
    user = User.get_one(id)
    print(user)
    return render_template('user.html', one_user = user)


@app.route('/delete/<int:id>')
def delete(id):
    User.delete(id)
    return redirect('/all')

@app.route('/edit/<int:id>')
def edit(id):
    user = User.get_one(id)
    return render_template('edit.html', one_user = user)

@app.route('/submit_edit/<int:id>', methods=['POST'])
def submit_edit(id):
    User.submit_edit(request.form)
    return redirect(f"/user/{id}")