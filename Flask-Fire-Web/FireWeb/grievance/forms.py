from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, DateField
from wtforms.widgets import TextArea
from wtforms.validators import DataRequired

class GrievanceForm(FlaskForm):

    dateOfIncident= DateField("Date of Grievance", [DataRequired()])
    title = StringField("Grievance subject", [DataRequired()])
    user = StringField("Who is filling the Grievance? (If filling on behalf of someone or department)")
    whatHappened = TextAreaField("Description", [DataRequired()])
    locationOfIncident = StringField("Where did it happen?", [DataRequired()])
    whenItHappened = DateField("When did it happen?", [DataRequired])
    whyGrievence = TextAreaField("Why is this a Grievance?")
    pastPractice = TextAreaField("Past Practice (Describe Fully)")
    unfairTreatment = TextAreaField("Unfair Treatment:")
    submitButton = SubmitField("Submit")

    #TODO add fields for:
    #status of grieve? this needs to be ironed out with stakeholder
    pass