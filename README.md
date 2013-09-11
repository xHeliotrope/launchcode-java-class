Instructions on how to use sqlite3

# build the database tables
.read metrolink.sql

#import the data
.separator ,
.import trips.txt trips

#remember the order of the csv columns get matched with database!

#helpful commands

.schema             #shows all tables schemas
.schema stops       #shows the schema for the stops table
.headers ON         #shows headers of the tables
.exit               #returns to the command prompt

