create index IX_13770111 on wrm_BookingAttendees (attendeesId);
create index IX_48794D31 on wrm_BookingAttendees (bookingId);

create index IX_6AEEDBBF on wrm_BookingFacilityMapping (bookingId);
create index IX_C0F212D5 on wrm_BookingFacilityMapping (facilitiesId);

create index IX_D0BF3625 on wrm_BookingRooms (bookingDate);
create index IX_48AF1992 on wrm_BookingRooms (bookingId);
create index IX_1874287C on wrm_BookingRooms (roomId);
create index IX_113ECB1B on wrm_BookingRooms (roomId, bookingDate);

create index IX_4825128A on wrm_CityMaster (cityName);

create index IX_DEA041A8 on wrm_FacilityMaster (facilitiesId);
create index IX_C013F858 on wrm_FacilityMaster (facilitiesName);

create index IX_1A6AFB20 on wrm_FloorMaster (floorName);
create index IX_C8DACCB on wrm_FloorMaster (locationId);

create index IX_6FE40424 on wrm_LocationMaster (cityId);
create index IX_77930C9E on wrm_LocationMaster (locationName);

create index IX_E6DF2C6E on wrm_NewBooking (fromDate, toDate, startTime, endTime);

create index IX_58B22519 on wrm_RoomFacilityMapping (facilitiesId);
create index IX_11C272B3 on wrm_RoomFacilityMapping (roomId);

create index IX_39E047CA on wrm_RoomMaster (cityId);
create index IX_6E59FEEE on wrm_RoomMaster (cityId, locationId);
create index IX_35240089 on wrm_RoomMaster (cityId, locationId, floorId);
create index IX_DF403FC7 on wrm_RoomMaster (floorId);
create index IX_D689B014 on wrm_RoomMaster (locationId);
create index IX_9322916A on wrm_RoomMaster (roomName);