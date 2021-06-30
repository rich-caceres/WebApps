from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, DateField
from wtforms.widgets import TextArea
from wtforms.validators import DataRequired

class GrievanceForm(FlaskForm):

    title = StringField("Grievance subject", [DataRequired()])
    userViolated = StringField("Who is the Grievance for? (Only if filling on behalf of someone or department)")
    whatHappened = TextAreaField("Description", [DataRequired()])
    locationOfIncident = StringField("Where did it happen?", [DataRequired()])
    whenItHappened = DateField("When did it happen?", [DataRequired()])
    article = StringField("Article in Contract")
    section = StringField("Section in Article")
    pastPractice = TextAreaField("Past Practice:")
    unfairTreatment = TextAreaField("Unfair Treatment:")
    other = TextAreaField("Other:")
    submit = SubmitField("Submit")
    #TODO add fields for:
    #status of grieve? this needs to be ironed out with stakeholder