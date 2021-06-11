from FireWeb import db,login_manager
from werkzeug.security import generate_password_hash, check_password_hash
from flask_login import UserMixin
import datetime

###Login Manager being added###
@login_manager.user_loader
def load_user(user_id):
    return User.query.get(user_id)

###Creates the user class object for signing in###
class User(db.Model, UserMixin):
    
    __tablename__= 'fduser'
        
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String, unique=True)
    password = db.Column(db.String)
    fname = db.Column(db.String)
    lname = db.Column(db.String)
    position_id = db.Column(db.Integer, db.ForeignKey('unionpos.id'))
    isActive = db.Column(db.Boolean)
    post = db.relationship('New_News', backref='userstatpost', lazy=True)
    isAdmin = db.Column(db.Boolean)
    badge_number = db.Column(db.String)
    
    def __init__(self, email, password, fname, lname, position_id, isActive, isAdmin, badge_number):

         self.email = email
         self.password = generate_password_hash(password)
         self.fname = fname
         self.lname = lname
         self.position_id = position_id
         self.isActive = isActive
         self.isAdmin = isAdmin
         self.badge_number = badge_number

    def setAdmin(self, booleanVal):
        self.isAdmin = booleanVal

    def setActive(self, booleanVal):
        self.isActive = booleanVal

    def setPosition(self, posId):
        self.position_id = posId

    def __repr__(self):
        return f"User badge number: {self.id}\nuser's full name: {self.fname} {self.lname}\n {self.position_id}"

    def check_password(self, password):
        return check_password_hash(self.password, password)

    def ReportPosts(self):
        for post in self.post:
            print(f"{post.status} Posted by {self.fname} {self.lname}")

        
###User Postiton within union###
class Union_User(db.Model):

    __tablename__='unionpos'

    id = db.Column(db.Integer, primary_key=True)
    positionName = db.Column(db.String, nullable=False)
    users = db.relationship('User', backref="userpos", lazy=True)


    def __init__(self, pos_name):
 
        self.positionName = pos_name

    def __repr__(self):
        return f"The position at ID {self.id} is: {self.positionName}"

    def reportUsers(self):
        for user in self.users:
            print(f"The user: {user.fname} {user.lname} holds the following position in the union: {self.positionName}")

###Recent news data model###
class New_News(db.Model):

    __tablename__='newsstatus'

    id = db.Column(db.Integer, primary_key = True)
    status = db.Column(db.Text, nullable=False)
    user_id = db.Column(db.Integer, db.ForeignKey('fduser.id'))
    date = db.Column(db.Date)

    def __init__(self, post, user_id):

        self.status = post
        self.user_id = user_id
        self.date = datetime.datetime.now()

    def __repr__(self):
        user = User.query.get(self.user_id)
        dates = self.date.strftime('%x') 
        return f'{self.status} ({user.fname} {user.lname} on {dates})'

class Grievance(db.Model):
    __tablename__ = 'grievance'

    id = db.Column(db.Integer, primary_key = True)
    name = db.Column(db.Text, nullable = False)
    reason = db.Column(db.Text, nullable = False)
    dateOfGrievance = db.Column(db.Date)


    def __init__(self, name, reason):
        self.name = name
        self.reason = reason
        self.dateOfGrievance = datetime.datetime.now()
        pass

    def __repr__(self):
        pass
    pass
###for testing this###
if __name__ == "__main__":

    our_user = session.query(User).filter_by(id=71).first()

    print(our_user.fname + " " + our_user.lname)
