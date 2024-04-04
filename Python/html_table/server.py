from flask import Flask, render_template
app = Flask(__name__)

users = [
{'first' : 'Michael', 'last' : 'Choi'},
{'first' : 'John', 'last' : 'Supsupin'},
{'first' : 'Mark', 'last' : 'Guillen'},
{'first' : 'KB', 'last' : 'Tonel'}
]



@app.route('/')
def start():
    return render_template('index.HTML', users=users)

if __name__=='__main__':
    app.run(debug=True)
