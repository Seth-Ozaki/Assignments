from belt_app import app
from flask import render_template, request, redirect, session, flash
from flask_bcrypt import Bcrypt
from belt_app.model.users import User
from belt_app.model.trips import Trip
bcrypt=Bcrypt(app)

@app.route('/logged/<int:id>')
def logged(id):
    if not 'user_id' in session:
        flash("You must be logged in!", "login")
        return redirect('/home')
    user = User.get_user(id)
    trips = Trip.get_users_trips()
    return render_template('logged.html', one_user = user, all_trips= trips)

@app.route('/new_trip/<int:id>')
def new_trip(id):
    if not 'user_id' in session:
        flash("You must be logged in!", "login")
        return redirect('/home')
    user = User.get_user(id)
    return render_template('new.html', one_user=user)

@app.route('/add_trip/<int:id>', methods=['POST'])
def add_trip(id):
    if not  Trip.validate_trip(request.form):
        return redirect(f"/new_trip/{id}")
    data = {
        "destination":request.form['destination'],
        "start_date":request.form['start_date'],
        "end_date":request.form['end_date'],
        "itinerary":request.form['itinerary'],
        "user_id":id
    }
    Trip.add_trip(data)
    return redirect(f"/logged/{id}")

@app.route('/trip/<int:id>')
def trip(id):
    if not 'user_id' in session:
        flash("You must be logged in!", "login")
        return redirect('/home')
    trip = Trip.get_trip(id)
    return render_template('trip.html', one_trip = trip)

@app.route('/delete_trip/<int:id>')
def delete_trip(id):
    Trip.delete_trip(id)
    return redirect(f"/logged/{session['user_id']}")

@app.route('/edit/<int:id>')
def edit(id):
    if not 'user_id' in session:
        flash("You must be logged in!", "login")
        return redirect('/home')
    trip = Trip.get_trip(id)
    return render_template('edit.html', one_trip = trip)

@app.route('/submit_edit/<int:id>', methods=['POST'])
def submit_edit(id):
    if not  Trip.validate_trip(request.form):
        return redirect(f"/edit/{id}")
    Trip.submit_edit(request.form)
    return redirect(f"/trip/{id}")