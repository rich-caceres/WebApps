from flask import Blueprint,render_template,redirect,url_for,request
from FireWeb import db
from FireWeb.userCreation import User
from FireWeb.login.forms import LoginForm
from werkzeug.security import check_password_hash

login_blueprint = Blueprint('signin',__name__,template_folder='templates\login')

@login_blueprint.route('/login', methods=['GET', 'POST'])
def login():
    form = LoginForm()
    if request.method == "POST":
          try:
              badge_number = form.badge_number.data
              password = form.password.data
              #print(badge_number)
              #print(password)
              #badge_number = request.form["BadgeInput"]
              #password = request.form["PasswordInput"]
          except:
               return render_template('SignIn.html', form=form, message= "Error with credentials, please try again later.")
          if User.query.get(badge_number) is None or badge_number == '':
              return render_template('SignIn.html', form=form, message = "No badge number found, try again.")
          #Old syntax used below and above db.session.query(User).filter_by(id = badge_number).first()
          user = User.query.get(badge_number)
          ##CHECKING TO SEE IF THE PASSWORD IS CORRECT### NOT IMPLEMENTED IN THIS VERSION YET
          if check_password_hash(user.password, password):
              return render_template('dashboard.html', message= "Successful login")
          else:
              return render_template('SignIn.html', form = form, message = "Password is incorrect, try again.")
    return render_template('SignIn.html', form = form)