import os
from FireWeb import app

from flask import Flask, render_template, url_for, request, redirect
from flask_login import login_user,login_required,logout_user
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
     return render_template('dashboard.html')

@app.errorhandler(404)
def page_not_found(e):
    return render_template('404.html')

if __name__ == "__main__":

    app.run()
     #TODO: Get to render the template dashboard
     #TODO: Digest user grievance forms
     #TODO: need to create a flow that the user can use for seeing maintenance on vehicle
     #NOTE: test badge is 71, pass is the normal pass

