import os

from flask import Flask, render_template, url_for, request, redirect
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker

app = Flask(__name__)
app.config['ENV'] = 'development'
app.config['DEBUG'] = True
app.config['TESTING'] = True

engine = create_engine(os.getenv('DATABASE_URL'))
db = scoped_session(sessionmaker(bind=engine))

@app.route('/')
def index():
     return render_template('index.html')

@app.route('/product')
def product():
     return render_template('BuyingPage.html')

@app.route('/history')
def history():
     return render_template('History.html')

@app.route('/user_sign_in')
def sign_in_page():
     return render_template('SignIn.html')

@app.route('/login', methods=["POST", "GET"])
def login():

     if request.method == "POST":
     #testing form retrieval
          badge_number = request.form["BadgeInput"]
          password = request.form["PasswordInput"]
          print(f"Badge number input: [badge_Number] \n Password Input: [password]")
          return redirect(request.url)
     
     return render_template('SignIn.html')

