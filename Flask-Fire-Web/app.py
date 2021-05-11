import os
from Classes.userCreation import User, Union_User
from Classes.forms.forms import LoginForm
#from Classes.config import DevelopmentConfig

from flask import Flask, render_template, url_for, request, redirect
from flask_sqlalchemy import SQLAlchemy
#from sqlalchemy import create_engine
#from sqlalchemy.orm import scoped_session, sessionmaker

app = Flask(__name__) #this will be moved to init.py
app.config.from_object('config.DevelopmentConfig')#os.environ['APP_SETTINGS']
#db = SQLAlchemy(app) this will be moved to init.py
app.config['SQLALCHEMY_TRACK_MODIFATIONS'] = False
#engine = create_engine(os.getenv('DATABASE_URL'))
#db = scoped_session(sessionmaker(bind=engine))
#Session =sessionmaker(bind=engine)
#session = Session()

@app.route('/')
def index():
     return render_template('index.html')

@app.route('/product')
def product():
     return render_template('BuyingPage.html')

@app.route('/history')
def history():
     return render_template('History.html')

@app.route('/user_sign_in', methods=['GET','POST'])
def sign_in_page():
    form = LoginForm()
    if request.method == "POST":
          try:
              badge_number = form.badge_number.data
              password = form.password.data
              print(badge_number)
              print(password)
              #badge_number = request.form["BadgeInput"]
              #password = request.form["PasswordInput"]
          except:
               return render_template('SignIn.html', form=form, message= "Error with credentials, please try again later.")
          if session.query(User).filter_by(id = badge_number).first() is None or badge_number == '':
              return render_template('SignIn.html', message = "No badge number found, try again.")
          
          ###GETTING THE USER FROM SESSION### NOT IMPLEMENTED IN THIS VERSION YET
          user = session.query(User).filter_by(id = badge_number).first()
          
          ##CHECKING TO SEE IF THE PASSWORD IS CORRECT### NOT IMPLEMENTED IN THIS VERSION YET
          if user is None or user.password != password:
              return render_template('SignIn.html', message = "Password is incorrect, try again.")
          else:
              return render_template('dashboard.html', message= "Successful login")

         #TODO: Will need to import the rest of SQL code to grab and check if the user is validated

    return render_template('SignIn.html', form = form)

@app.route('/dashboard')
def dashboard():
     return render_template('dashboard.html')

@app.errorhandler(404)
def page_not_found(e):
    return render_template('404.html',404)

if __name__ == "__main__":

    app.run()
     #TODO: Get to render the template dashboard
     #TODO: Digest user grievance forms
     #TODO: need to create a flow that the user can use for seeing maintenance on vehicles
     #TODO: Currently, the user can login but we get a 500 error, probably nothing serious, just need to review app.route configurations
     #NOTE: test badge is 71, pass is the normal pass

