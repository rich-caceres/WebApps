import os
from FireWeb import app, db

from flask import Flask, render_template, url_for, request, redirect
from flask_login import login_user,login_required,logout_user, current_user

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
     return redirect(url_for('status.rec_status'))

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
    return render_template('404.html'), 404

@app.route('/logout')
@login_required
def logout():
    logout_user()
    return redirect(url_for('signin.login'))

###TODO: need to create front end for the admin user, will use openpyxl to create user accounts.###
@app.route('/admin')
@login_required
def admin_page_dash():
    if current_user.isAdmin:
        return render_template('dashboard.html')
    else:
        return render_template('admin.html')
    pass

if __name__ == "__main__":

    app.run()
     #TODO: Digest user grievance forms
     #TODO: need to create a flow that the user can use for seeing maintenance on vehicle
     #NOTE: test email check at user creation, pass is the normal pass

