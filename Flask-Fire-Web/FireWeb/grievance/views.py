from flask import Blueprint,render_template,redirect,url_for,request
from FireWeb import db
from FireWeb.userCreation import User, Grievance
from FireWeb.grievance.forms import GrievanceForm

grievence_blueprint = Blueprint('grievence',__name__)

@grievence_blueprint.route('dashborad/forms/grievence', methods=["GET", "POST"])
def Grievences():
    if request.method == "POST":
        grievance = Grievance(form.user.data, form.title.data, form.whenItHappened.data, form.locationOfIncident.data, form.article.data + " " + form.section.data, form.pastPractice.data, form.unfairTreatment.data, form.other.data)#finish adding the rest of the grievance
                               #must get current user name entering the grievance
    pass