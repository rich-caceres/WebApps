from flask import Blueprint,render_template,redirect,url_for,request
from FireWeb import db
from FireWeb.userCreation import User
from FireWeb.grievance.forms import GrievanceForm

grievence_blueprint = Blueprint('grievence',__name__)

@grievence_blueprint.route('dashborad/forms/grievence', methods=["GET", "POST"])
def Grievences():

    pass