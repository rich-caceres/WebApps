from flask import Blueprint,render_template,redirect,url_for,request
from flask_login import login_user,login_required,logout_user, current_user
from FireWeb import db
from FireWeb.userCreation import User, New_News
from FireWeb.status.forms import StatusForm 

status_blueprint = Blueprint('status',__name__)

@status_blueprint.route('/dashboard/statuses', methods=["GET","POST"])
@login_required
def rec_status():
     last_ten_statuses = {}
     form = StatusForm()
     if request.method == "POST":
        status = New_News(form.status.data, current_user.id)
        db.session.add(status)
        db.session.commit()
     try:
        allStatuses = New_News.query.all()
        rows = len(allStatuses)
        if rows > 10:
            for row in range(rows, rows-10, -1):
                last_ten_statuses[row]= New_News.query.get(row)
            return render_template('dashboard.html', form=form, last_ten_items = last_ten_statuses)
        else:
            for row in range(rows, 0, -1):
                last_ten_statuses[row]= New_News.query.get(row)
            return render_template('dashboard.html', form=form, last_ten_items = last_ten_statuses)
     except:
        print(last_ten_statuses)
        return render_template('dashboard.html', form=form)