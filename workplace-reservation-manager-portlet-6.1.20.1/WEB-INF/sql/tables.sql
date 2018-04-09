create table wrm_BookingAttendees (
	attendeesId LONG not null,
	bookingId LONG not null,
	primary key (attendeesId, bookingId)
);

create table wrm_BookingFacilityMapping (
	bookingId LONG not null,
	facilitiesId LONG not null,
	primary key (bookingId, facilitiesId)
);

create table wrm_BookingRooms (
	BRMappingId LONG not null primary key,
	bookingId LONG,
	roomId LONG,
	bookingDate DATE null
);

create table wrm_CityMaster (
	cityId LONG not null primary key,
	cityName VARCHAR(75) null
);

create table wrm_FacilityMaster (
	facilitiesId LONG not null primary key,
	facilitiesName VARCHAR(75) null,
	facilitiesDesc VARCHAR(75) null
);

create table wrm_FloorMaster (
	floorId LONG not null primary key,
	locationId LONG,
	floorName VARCHAR(75) null
);

create table wrm_LocationMaster (
	locationId LONG not null primary key,
	cityId LONG,
	locationName VARCHAR(75) null
);

create table wrm_NewBooking (
	bookingId LONG not null primary key,
	meetingTitle VARCHAR(75) null,
	meetingDesc VARCHAR(75) null,
	hostId LONG,
	fromDate DATE null,
	toDate DATE null,
	startTime VARCHAR(75) null,
	endTime VARCHAR(75) null
);

create table wrm_RoomFacilityMapping (
	roomId LONG not null,
	facilitiesId LONG not null,
	primary key (roomId, facilitiesId)
);

create table wrm_RoomMaster (
	roomId LONG not null primary key,
	cityId LONG,
	locationId LONG,
	floorId LONG,
	roomName VARCHAR(75) null,
	capacity LONG,
	extension LONG
);