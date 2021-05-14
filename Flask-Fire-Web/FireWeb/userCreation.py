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

    def __init__(self, user_id, password, fname, lname, position_id, isActive):

         self.id = user_id
         self.password = password
         self.fname = fname
         self.lname = lname
         self.position_id = position_id
         self.isActive = isActive

    def __repr__(self):
        return f"User badge number: {self.id}\nuser's full name: {self.fname} {self.lname}\n position in union: {self.position_id}"

        
###User Postiton within union###
class Union_User(db.Model):

    __tablename__='unionpos'

    id = db.Column(db.Integer, primary_key=True)
    position = db.Column(db.String)
    users = db.relationship('User', backref="userpos", lazy='dynamic')

    def __init__(self, pos_id, pos_name):

        self.id = pos_id
        self.position = pos_name

    def __repr__(self):
        return f"The position at ID {self.id} is: {self.position}"

###for testing this###
if __name__ == "__main__":

    our_user = session.query(User).filter_by(id=71).first()

    print(our_user.fname + " " + our_user.lname)
