# Have the root route ("/") show a page with the form

# Have the "/result" route display the information from the form on a new HTML page

# Put the form data into session

# NINJA BONUS: Use a CSS framework to style your form

# NINJA BONUS: Include a set of radio buttons on your form

# SENSEI BONUS: Include a set of checkboxes on your form


from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key='placeholder key'

@app.route('/')
def start():
    return render_template('index.html')

@app.route('/submitted', methods=['POST'])
def submitted():
    session['name']=request.form.get('name')
    session['location']=request.form.get('location')
    session['language']=request.form.get('language')
    session['comments']=request.form.get('comments')
    session['dog']=request.form.get('dog')
    if session['dog']== 'on':
        session['dog']='They do like dogs'
    else:
        session['dog']='L Bozo'
    return redirect('/display')

@app.route('/display')
def display():
    return render_template('show.html',  name_on_template=session['name'], location_on_template=session['location'], language_on_template=session['language'], comments_on_template=session['comments'], dog_on_template=session['dog'])

@app.route('/reset')
def reset():
    return redirect('/')


if __name__=='__main__':
    app.run(debug=True)