from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, DateField
from wtforms.validators import DataRequired

class StatusForm(FlaskForm):
    
    status = StringField("Status", [DataRequired(message = "Status required")])
    date = DateField("Date")
    submit = SubmitField("Post Update")