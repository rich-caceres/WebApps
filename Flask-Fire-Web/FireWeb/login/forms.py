from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired, Email

class LoginForm(FlaskForm):
    
    email = StringField("Email", [Email(), DataRequired(message = "Please enter badge number")])
    password = StringField("Password", [DataRequired(message = "Please enter a password")])
    submit = SubmitField("Login")
  