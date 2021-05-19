from flask import Blueprint,render_template,redirect,url_for,request
from FireWeb import db
from FireWeb.userCreation import User
from FireWeb.grievance.forms import GrievanceForm


login_blueprint = Blueprint('grievence',__name__,template_folder='templates\girevence')

@login_blueprint.route('/grievence', methods=["GET", "POST"])
def Grievences():
    pass