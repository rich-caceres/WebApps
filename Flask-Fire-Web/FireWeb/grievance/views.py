from flask import Blueprint,render_template,redirect,url_for,request
from flask_login import current_user

from FireWeb import db
from FireWeb.userCreation import User, Grievance
from FireWeb.grievance.forms import GrievanceForm

grievance_blueprint = Blueprint('grievance',__name__)

@grievance_blueprint.route('forms/grievance', methods=["GET", "POST"])
def Grievences():
    form = GrievanceForm()
    if request.method == "POST":
        grievance = Grievance(current_user.fname + " " + current_user.lname, form.title.data, form.whenItHappened.data, 
                              form.locationOfIncident.data, form.article.data + " " + form.section.data, 
                              form.pastPractice.data, form.unfairTreatment.data, form.other.data)
        db.session.add(grievance)
        db.session.commit()
        return redirect(url_for('union_forms'))
    if current_user.position_id == range(3):
        all_grievances = Grievance.query.all()
        #TODO: add all grievances to the view for viewing to president, vice-president, and  secretary of treasure.
        #TODO: need to create committees so that the users can send directly to grievance committees.
        #must get current user name entering the grievance
    return render_template('grievence.html', form = form)

@grievance_blueprint.route('/grieveList')
def GrievanceList():
    grieveList = Grievance.query.all()
    return render_template('listOfGrieve.html', grieveList = grieveList)