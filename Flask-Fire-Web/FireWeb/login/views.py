from flask import Blueprint,render_template,redirect,url_for,request
from flask_login import login_user,login_required,logout_user
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
          except:
               return render_template('SignIn.html', form=form, message= "Error with credentials, please try again later.")
          if User.query.get(badge_number) is None or badge_number == '':
              return render_template('SignIn.html', form=form, message = "No badge number found, try again.")
          
          ###gets user from database###
          user = User.query.get(badge_number)
          print(user.position_id)
          ##CHECKING TO SEE IF THE PASSWORD IS CORRECT###
          if user.check_password(password):
              login_user(user)
              return render_template('dashboard.html', message = "Welcome")
          else:
              return render_template('SignIn.html', form = form, message = "Password is incorrect, try again.")
    return render_template('SignIn.html', form = form)
