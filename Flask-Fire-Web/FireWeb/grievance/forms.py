from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, DateField
from wtforms.widgets import TextArea
from wtforms.validators import DataRequired

class GrievanceForm(FlaskForm):

    dateOfIncident= DateField("Date of Incedent", [DataRequired()])
    title = StringField("Grievance Title/Reason", [DataRequired()])
    user = StringField("Reporting party", [DataRequired()])
    body = TextAreaField("Description", [DataRequired()])
    submitButton = SubmitField("Submit")

    #TODO add fields for:
    #status of grieve? this needs to be ironed out with stakeholder
    pass