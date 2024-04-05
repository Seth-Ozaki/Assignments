from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key='placeholder'

@app.route('/')
def start():
    if session.get('count') is not None:
        session['count']+=1
    else:
        session['count']=0
    return render_template('index.html', session_count=session['count'] )
    

@app.route('/destroy')
def destroy():
    session.clear()
    return redirect ('/')

@app.route('/two')
def two():
    session['count']+=2
    return render_template('index.html')

@app.route('/reset')
def reset():
    session.pop('count')
    return redirect ('/')

@app.route('/plus', methods=['POST'])
def plus():
    session['amount'] = request.form.get('amount', type=int)
    return redirect('plus1')

@app.route('/plus1')
def plus1():
    session['count'] += session['amount']
    return render_template('index.html')


if __name__=='__main__':
    app.run(debug=True)