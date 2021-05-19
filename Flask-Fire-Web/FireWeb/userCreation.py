#set up db inside __init__.py
from FireWeb import db

###Creating the database connection###
#engine = create_engine(os.getenv('DATABASE_URL'))
#Base = declarative_base(engine) 
#db = scoped_session(sessionmaker(bind=engine))for testing will remove
#Session = sessionmaker(bind=engine)
#session = Session()

###Creates the user class object for signing in###
class User(db.Model):
    
    __tablename__= 'fduser'
        
    id = db.Column(db.Integer, primary_key=True)
    password = db.Column(db.String)
    fname = db.Column(db.String)
    lname = db.Column(db.String)
    position_id = db.Column(db.Integer, db.ForeignKey('unionpos.id'))
    isActive = db.Column(db.Boolean)
    post = db.relationship('New_News', backref='userstatpost', lazy='dynamic')

    def __init__(self, user_id, password, fname, lname, position_id, isActive):

         self.id = user_id
         self.password = password
         self.fname = fname
         self.lname = lname
         self.position_id = position_id
         self.isActive = isActive

    def __repr__(self):
        return f"User badge number: {self.id}\nuser's full name: {self.fname} {self.lname}\n {self.position_id}"

    def ReportPosts(self):
        for p in post:
            return f"{p.status} posted by {self.fname} {self.lname}"
        
###User Postiton within union###
class Union_User(db.Model):

    __tablename__='unionpos'

    id = db.Column(db.Integer, primary_key=True)
    positionName = db.Column(db.String)
    users = db.relationship('User', backref="userpos", lazy='dynamic')


    def __init__(self, pos_name):
 
        self.positionName = pos_name

    def __repr__(self):
        return f"The position at ID {self.id} is: {self.positionName}"

    def reportUsers(self):
        for user in self.users:
            return f"The user: {user.fname} holds the following position in the union: {self.positionName}"

class New_News(db.Model):

    __tablename__='newsstatus'

    id = db.Column(db.Integer, primary_key = True)
    status = db.Column(db.String)
    user_id = db.Column(db.Integer, db.ForeignKey('fduser.id'))

    def __init__(self, post, user_id):

        self.post=post
        self.user_id = user_id


###for testing this###
if __name__ == "__main__":

    our_user = session.query(User).filter_by(id=71).first()

    print(our_user.fname + " " + our_user.lname)
