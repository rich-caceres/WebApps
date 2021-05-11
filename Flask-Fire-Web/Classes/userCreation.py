import os

###SQL Alchemy Imports###
from flask_sqlalchemy import sqlalchemy

basedir = os.path.abspath(os.path.dirname(__file__))

###Creating the database connection###
#engine = create_engine(os.getenv('DATABASE_URL'))
#Base = declarative_base(engine) 
#db = scoped_session(sessionmaker(bind=engine))for testing will remove
#Session = sessionmaker(bind=engine)
#session = Session()

###Creates the user class object for signing in###
class User(db.Model):
    
    __tablename__= 'fduser'
        
    id = Column(db.Integer, primary_key=True)
    password = Column(db.String)
    fname = Column(db.String)
    lname = Column(db.String)
    position_id = Column(db.Integer, ForeignKey('unionuser.id'))
    posotion = relationship("Union_User")

    def __init__(self, user_id, password, fname, lname, position):

         self.user_id = user_id
         self.password = password
         self.fname = fname
         slef.lname = lname
         self.position = position

        
###User Postiton within union###
class Union_User(db.Model):

    __tablename__='unionuser'

    id = Column(db.Integer, primary_key=True)
    position = Column(db.String)

    def __init__(self, pos_id, pos_name):

        self.id = pos_id
        self.position = pos_name

    def __repr__():

        return f"The position at ID {self.id} is: {self.position}"

###for testing this###
if __name__ == "__main__":

    our_user = session.query(User).filter_by(id=71).first()

    print(our_user.fname + " " + our_user.lname)
