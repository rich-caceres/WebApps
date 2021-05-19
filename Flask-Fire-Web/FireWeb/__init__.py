import os
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

app = Flask(__name__)
app.config.from_object('config.DevelopmentConfig')
app.config['SQLALCHEMY_TRACK_MODIFATIONS'] = False

db = SQLAlchemy(app)
Migrate(app,db, render_as_batch= True)

from FireWeb.login.views import login_blueprint
from FireWeb.grievance.views import grievence_blueprint

app.register_blueprint(login_blueprint, url_prefix='/signin')
app.register_blueprint(grievence_blueprint, url_prefix='/grievence')