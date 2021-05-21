from FireWeb import db,login_manager
from werkzeug.security import generate_password_hash, check_password_hash
from flask_login import UserMixin

###Login Manager being added###
@login_manager.user_loader
def load_user(user_id):
    return User.query.get(user_id)

###Creates the user class object for signing in###
class User(db.Model, UserMixin):
    
    __tablename__= 'fduser'
        
    id = db.Column(db.Integer, primary_key=True)
    password = db.Column(db.String)
    fname = db.Column(db.String)
    lname = db.Column(db.String)
    position_id = db.Column(db.Integer, db.ForeignKey('unionpos.id'))
    isActive = db.Column(db.Boolean)
    post = db.relationship('New_News', backref='userstatpost', lazy=True)

    def __init__(self, user_id, password, fname, lname, position_id, isActive):

         self.id = user_id
         self.password = generate_password_hash(password)
         self.fname = fname
         self.lname = lname
         self.position_id = position_id
         self.isActive = isActive

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

class New_News(db.Model):

    __tablename__='newsstatus'

    id = db.Column(db.Integer, primary_key = True)
    status = db.Column(db.Text, nullable=False)
    user_id = db.Column(db.Integer, db.ForeignKey('fduser.id'))

    def __init__(self, post, user_id):

        self.status = post
        self.user_id = user_id

    def __repr__(self):
        return f'post id: {self.id}\npost: {self.status}\nuser:{self.user_id}'

###for testing this###
if __name__ == "__main__":

    our_user = session.query(User).filter_by(id=71).first()

    print(our_user.fname + " " + our_user.lname)
