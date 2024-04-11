from flask import Flask, render_template, request, redirect, session
from user import User
app = Flask(__name__)
app.secret_key='placeholder key'


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

if __name__=='__main__':
    app.run(debug=True)