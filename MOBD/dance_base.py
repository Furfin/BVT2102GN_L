from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Boolean, Column, Date, ForeignKey,Integer,String,create_engine,ARRAY, Table
from sqlalchemy.schema import CreateTable
from sqlalchemy.orm import sessionmaker, relationship
from sqlalchemy.dialects import postgresql
import os

DATABASE_URI = "postgresql://postgres:postgres@localhost:5432/postgres"
Base = declarative_base()
globalEngine = create_engine(DATABASE_URI)

RegionSchool = Table('RegionSchool',Base.metadata,
    Column('id', Integer, primary_key=True),
    Column('SchoolId', Integer, ForeignKey('School.id')),
    Column('DanceId', Integer, ForeignKey('Dance.id')),
)

class Region(Base):
    __tablename__ = "Region"
    id = Column(Integer,primary_key=True)
    name = Column(String)
    

class School(Base):
    __tablename__ = "School"
    id = Column(Integer,primary_key=True)
    name = Column(String)
    region_id = Column(Integer,ForeignKey(Region.id))

class Dance(Base):
    __tablename__ = "Dance"
    id = Column(Integer,primary_key=True)
    name = Column(String)
    
    
def setup():
    engine = create_engine(DATABASE_URI)
    Base.metadata.create_all(engine)
    Session = sessionmaker(bind = engine)
    return Session

def drop_all():
    engine = create_engine(DATABASE_URI)
    Base.metadata.drop_all(engine)