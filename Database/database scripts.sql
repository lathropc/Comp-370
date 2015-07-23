/*
Database name: trains
*/

--create table script for tracks
create table tracks (
	trackid varchar(4),
	pretrack1 varchar(4),
	pretrack2 varchar(4),
	posttrack1 varchar(4),
	posttrack2 varchar(4),
	isallocated varchar(1) default 'N',
	isalive varchar(1) default 'Y'
);

--example insert for the first section of track
insert into tracks (trackid, pretrack1, pretrack2, posttrack1, posttrack2) 
values ('S1-1', null, null, 'S2-1', null);

--create table for switches
create table switch (
	switchid varchar(4),
	pretrack1 varchar(4),
	pretrack2 varchar(4),
	posttrack1 varchar(4),
	posttrack2 varchar(4),
	isallocated varchar(1) default 'N',
	isalive varchar(1) default 'Y'
);

--example insert for the first switch
insert into tracks (switchid, pretrack1, pretrack2, posttrack1, posttrack2) 
values ('SW-1', 'S2-1', 'S2-2', 'S3-1', null);

--create table for stations
create table switch (
	stationid varchar(20),
	trackid1 varchar(4),
	trackid2 varchar(4),
	trackid3 varchar(4),
	trackid4 varchar(4),
	isalive varchar(1) default 'Y'
);

--example insert for the first switch
insert into tracks (stationid, trackid1, trackid2, trackid3, trackid4) 
values ('Boston', 'S1-1', 'S1-2', 'S1-3', 'S1-4');

