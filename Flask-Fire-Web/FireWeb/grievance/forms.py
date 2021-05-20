from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, DateField
from wtforms.widgets import TextArea
from wtforms.validators import DataRequired

class GrievanceForm(FlaskForm):

    dateOfIncident= DateField("Date of Incedent", validators[DataRequired(message = "Date Required")])
    title = StringField("Grievance Title", validators[DataRequired(message = "Title Required")])
    body = TextAreaField("Description", validators[DataRequired(message = "Description Required")])
    
    #TODO add fields for:
    #entering party
    #reason for grieve
    #date of grieve
    #status of grieve? this needs to be ironed out with stakeholder
    #submit the form
    pass