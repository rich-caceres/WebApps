import os

from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker
from sqlalchemy import Column, Integer, String
from sqlalchemy.ext.declarative import declarative_base


engine = create_engine(os.getenv('DATABASE_URL'))
Base = declarative_base(engine) 
#db = scoped_session(sessionmaker(bind=engine))
Session = sessionmaker(bind=engine)
session = Session()


class User(Base):
    
    __tablename__= 'fduser'
        
    id = Column(Integer, primary_key=True)
    password = Column(String)
    fname = Column(String)
    lname = Column(String)
    position = Column(String)

    def __init__(self, user_id, password, fname, lnme, position):

         self.user_id = user_id
         self.password = password
         self.fname = fname
         slef.lname = lname
         self.position = position

        

class Union_User(Base):

    __tablename__='unionuser'

    id = Column(Integer, primary_key=True)
    position = Column(String)


if __name__ == "__main__":

    our_user = session.query(User).filter_by(id=71).first()

    print(our_user.fname + " " + our_user.lname)
