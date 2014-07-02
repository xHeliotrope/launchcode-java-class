Instructions on how to use sqlite3


To view the database navigate to the directory of the database file and type on the command line

sqlite3 metrolink.db


To exit the database type

.exit


To view the schema of the database type
.schema


To view the schema of a single table type
.schema {table name}


# build the database tables

.read metrolink.sql


#import the data

.separator ,

.import trips.txt trips


#remember the order of the csv columns get matched with database!


#helpful commands


.schema             -shows all tables schemas

.schema stops       -shows the schema for the stops table

.headers ON         -shows headers of the tables

.exit               -returns to the command prompt

.mode csv           -sets output to csv

.mode stdout        -returns output to standard out (console)

.output some.txt    -the file that you would like the csv to occupy
