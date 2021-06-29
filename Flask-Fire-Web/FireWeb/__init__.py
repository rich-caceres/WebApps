import os
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from flask_login import LoginManager

login_manager = LoginManager()

app = Flask(__name__)
app.config.from_object('config.DevelopmentConfig')
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)
Migrate(app,db, render_as_batch= True)

login_manager.init_app(app)
login_manager.login_view = 'signin.login'

from FireWeb.login.views import login_blueprint
from FireWeb.grievance.views import grievance_blueprint
from FireWeb.status.views import status_blueprint

app.register_blueprint(login_blueprint, url_prefix='/signin')
app.register_blueprint(grievance_blueprint, url_prefix='/grievance')
app.register_blueprint(status_blueprint,url_prefix='/dashboard/statuses')