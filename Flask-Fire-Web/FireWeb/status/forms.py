from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, IntegerField
from wtforms.validators import DataRequired

class StatusForm(FlaskForm):
    
    status = StringField("Status", [DataRequired(message = "Status required")])
    submit = SubmitField("Post")