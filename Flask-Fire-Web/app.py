import os
from userCreation import User, Union_User

from flask import Flask, render_template, url_for, request, redirect
from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker

app = Flask(__name__)
app.config['ENV'] = 'development'
app.config['DEBUG'] = True
app.config['TESTING'] = True

engine = create_engine(os.getenv('DATABASE_URL'))
db = scoped_session(sessionmaker(bind=engine))
Session =sessionmaker(bind=engine)
session = Session()

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

@app.route('/login_success')
def login_success():
     return render_template('dashboard.html')

@app.route('/login', methods=["POST", "GET"])
def login():

     if request.method == "POST":
          try:
               badge_number = request.form["BadgeInput"]
               password = request.form["PasswordInput"]
          except:
               return render_template('SignIn.html', message= "Error with credentials, please try again later.")

          """db.execute("SELECT * FROM fduser WHERE id = :id", {"id": badge_number})"""
     if session.query(User).filter_by(id = badge_number).first() is None or badge_number == '':
          return render_template('SignIn.html', message = "No badge number found, try again.")

     #Code is working, I'm dumb and used is over == to compare strings.
     user = session.query(User).filter_by(id = badge_number).first() #db.execute("SELECT password FROM fduser WHERE id = :id", {"id": badge_number}).fetchall()
     print(user.password)
     if user is None:
          return render_template('SignIn.html', message = "Password is incorrect, try again.")
     else:
          return render_template('dashboard.html', message= "Successful login")
     
     return render_template('SignIn.html')

     #TODO: Get to render the template dashboard
     #TODO: need to create a flow that the user can use for seeing maintenance on vehicles
     #TODO: Currently, the user can login but we get a 500 error, probably nothing serious, just need to review app.route configurations
     #NOTE: test badge is 71, pass is the normal pass

