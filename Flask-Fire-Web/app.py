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
          try:
               badge_number = request.form["BadgeInput"]
               password = request.form["PasswordInput"]
          except:
               return render_template('SignIn.html', message= "Error with credentials, please try again later.")
          
     if db.execute("SELECT * FROM fduser WHERE id = :id", {"id": badge_number}).rowcount == 0 or badge_number is None:
          return render_template('SignIn.html', message = "No badge number found, try again.")

     #The code below is not working, will need to create a user base to access data possibly.
     userpass= db.execute("SELECT pass FROM fduser WHERE id = :id", {"id": badge_number}).fetchall()
     print(userpass)
     if userpass is not password or password is None:
          return render_template('SignIn.html', message = "Password is incorrect, try again.")
     
     
     return render_template('SignIn.html')

