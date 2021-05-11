from flask import Blueprint,render_template,redirect,url_for,request
from FireWeb import db
from FireWeb.userCreation import User
from FireWeb.login.forms import LoginForm

login_blueprint = Blueprint('signin',__name__,template_folder='templates\login')

@login_blueprint.route('/login', methods=['GET', 'POST'])
def login():
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
    return render_template('SignIn.html', form = form)