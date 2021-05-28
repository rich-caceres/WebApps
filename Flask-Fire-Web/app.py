import os
from FireWeb import app, db
from FireWeb.login.forms import LoginForm
from FireWeb.status.forms import StatusForm
from FireWeb.userCreation import New_News

from flask import Flask, render_template, url_for, request, redirect
from flask_login import login_user,login_required,logout_user, current_user
from flask_sqlalchemy import SQLAlchemy


@app.route('/')
def index():
     return render_template('index.html')

@app.route('/product')
def product():
     return render_template('BuyingPage.html')

@app.route('/history')
def history():
     return render_template('History.html')

@app.route('/dashboard')
@login_required
def dashboard():
     return redirect(url_for('rec_status'))

@app.route('/dashboard/statuses', methods=["GET","POST"])
@login_required
def rec_status():
     last_ten_statuses = {}
     form = StatusForm()
     if request.method == "POST":
        status = New_News(form.status.data, current_user.id)
        db.session.add(status)
        db.session.commit()
     allStatuses = New_News.query.all()
     rows = len(allStatuses)
     if rows > 10:
        for row in range(rows-10, rows):
            last_ten_statuses[row]= New_News.query.get(row)
     else:
         for row in range(1, rows+1):
             last_ten_statuses[row]= New_News.query.get(row)
     print(last_ten_statuses)
     return render_template('dashboard.html', form=form, last_ten_items = last_ten_statuses)

@app.route('/dashboard/minutes')
@login_required
def month_mins():
     return render_template('dashboard.html')

@app.route('/dashboard/roster')
@login_required
def act_roster():
     return render_template('dashboard.html')

@app.route('/dashboard/apparel')
@login_required
def member_apparel():
     return render_template('dashboard.html')

@app.route('/dashboard/forms')
@login_required
def union_forms():
     return render_template('dashboard.html')

@app.errorhandler(404)
def page_not_found(e):
    return render_template('404.html')

@app.route('/logout')
@login_required
def logout():
    logout_user()
    return redirect(url_for('signin.login'))


if __name__ == "__main__":

    app.run()
     #TODO: Get to render the template dashboard
     #TODO: Digest user grievance forms
     #TODO: need to create a flow that the user can use for seeing maintenance on vehicle
     #NOTE: test badge is 71, pass is the normal pass

