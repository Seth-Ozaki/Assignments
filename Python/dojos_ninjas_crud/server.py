from flask import Flask, render_template, request, redirect, session
from ninjas import Ninja
from dojos import Dojo
app = Flask(__name__)
app.secret_key = "key"

@app.route('/')
def start():
    Ninja.clear()
    Dojo.clear()
    dojos=Dojo.get_all_dojos()
    return render_template('home.html', all_dojos=dojos)

@app.route('/all')
def all():
    dojos=Dojo.get_all_dojos()
    return render_template('home.html', all_dojos=dojos)

@app.route('/add')
def add():
    dojos=Dojo.get_all_dojos()
    return render_template('new_ninja.html',all_dojos=dojos)

@app.route('/dojo/<int:id>')
def dojo(id):
    dojo = Dojo.get_dojo_ninjas({"id":id})
    return render_template('all_dojo_ninjas.html', one_dojo=dojo)

@app.route('/submit_dojo', methods=['POST'])
def submit_dojo():
    Dojo.submit_dojo(request.form)
    return redirect('/all')

@app.route('/submit_ninja', methods=['POST'])
def submit_ninja():
    Ninja.submit_ninja(request.form)
    return redirect('/all')

if __name__=='__main__':
    app.run(debug=True)