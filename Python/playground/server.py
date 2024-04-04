from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def hello():
    return render_template('index.HTML', amount =0, color = 'blue')
    
@app.route('/play')
def play():
    return render_template('index.HTML', amount =3, color = 'blue')

@app.route('/play/<int:amount>')
def playnumber(amount=3,color='blue'):
    return render_template('index.HTML',amount = amount, color = color)

@app.route('/play/<int:amount>/<color>')
def playfull(amount=3,color='blue'):
    return render_template('index.HTML',amount = amount, color = color)




if __name__=="__main__":
    app.run(debug=True)