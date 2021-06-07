from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.fields.html5 import EmailField
from wtforms.validators import DataRequired, Email

class LoginForm(FlaskForm):
    
    email = EmailField("Email", [Email(message = "Please enter a valid email address!"), DataRequired(message = "Please enter your email")])
    password = StringField("Password", [DataRequired(message = "Please enter a password")])
    submit = SubmitField("Login")
  