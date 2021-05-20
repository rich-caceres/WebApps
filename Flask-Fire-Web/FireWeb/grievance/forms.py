from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, DateField
from wtforms.widgets import TextArea
from wtforms.validators import DataRequired

class GrievanceForm(FlaskForm):

    dateOfIncident= DateField("Date of Incedent", [DataRequired()])
    title = StringField("Grievance Title/Reason", [DataRequired()])
    body = TextAreaField("Description", [DataRequired()])
    
    #TODO add fields for:
    #entering party
    #reason for grieve
    #date of grieve
    #status of grieve? this needs to be ironed out with stakeholder
    #submit the form
    pass