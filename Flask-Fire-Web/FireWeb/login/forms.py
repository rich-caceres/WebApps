from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired

class LoginForm(FlaskForm):
    
    badge_number = StringField("Badge Number", [DataRequired(message = "Please enter badge number")])
    password = StringField("Password", [DataRequired(message = "Please enter a password")])
    submit = SubmitField("Login")
  