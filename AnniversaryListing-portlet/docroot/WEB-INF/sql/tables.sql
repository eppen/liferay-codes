create table add_anniversarywish (
	id_ LONG not null primary key,
	userId VARCHAR(75) null,
	wishedBy VARCHAR(75) null,
	message VARCHAR(75) null,
	createdDate DATE null
);