from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, DateField, RadioField
from wtforms.widgets import TextArea
from wtforms.validators import DataRequired

class GrievanceForm(FlaskForm):

    dateOfIncident= DateField("Date of Grievance", [DataRequired()])
    title = StringField("Grievance subject", [DataRequired()])
    user = StringField("Who is filling the Grievance? (If filling on behalf of someone or department)", [DataRequired()])
    whatHappened = TextAreaField("Description", [DataRequired()])
    locationOfIncident = StringField("Where did it happen?", [DataRequired()])
    whenItHappened = DateField("When did it happen?", [DataRequired])
    radioField = RadioField("What type of Grievance?",choices= [('unfair_treament','Unfair Treament'),('past_practice', 'Past Practice'),('other', 'Other')])
    article = StringField("Article and Section in Contract")
    section = StringField("Section in Article")
    pastPractice = TextAreaField("Past Practice:")
    unfairTreatment = TextAreaField("Unfair Treatment:")
    other = TextAreaField("Other:")
    submitButton = SubmitField("Submit")

    #TODO add fields for:
    #status of grieve? this needs to be ironed out with stakeholder
    pass