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