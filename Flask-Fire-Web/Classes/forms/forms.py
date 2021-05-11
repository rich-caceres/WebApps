from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired

class LoginForm(FlaskForm):
    
    badge_number = StringField("Badge Number")
    Password = StringField("Password")
    submit = SubmitField("Login")
  