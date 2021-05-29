from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired

class StatusForm(FlaskForm):
    
    status = StringField("Status", [DataRequired(message = "Status required")])
    submit = SubmitField("Post Update")