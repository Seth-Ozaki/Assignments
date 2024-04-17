from belt_app.controller import routes_trip
from belt_app.controller import routes_user
from belt_app import app
from flask import Flask



if __name__=='__main__':
    app.run(debug=True)