
drop table if exists trips;
drop table if exists routes;
drop table if exists stops;
drop table if exists stop_times;

create table trips (
	block_id char(40),
	route_id char(40),
	direction_id char(2),
	trip_headsign char(20),
	shape_id char(20),
	service_id char(20),
	trip_id char(20)
);

create table routes (
	route_long_name char(200),
	route_id char(40),
	route_type char(40),
	agency_id char(40),
	route_color char(40),
	route_short_name char(40)
);

create table stops (
	stop_lat Decimal(9,6),
	zone_id char(30),
	stop_lon Decimal(9,6),
	stop_id char(30),
	stop_desc char(30),
	stop_name char(30),
	location_type char(30)
);

create table stop_times ( 
	trip_id char(40),
	arrival_time char(40), 
	departure_time char(40), 
	stop_id char(40), 
	stop_sequence char(40), 
	stop_headsign char(40), 
	pickup_type char(40), 
	drop_off_type char(40), 
	shape_dist_traveled char(40)
);
