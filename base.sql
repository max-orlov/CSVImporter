CREATE TABLE forms(
  id integer PRIMARY KEY generated always as identity,
	ssoid varchar,
	ts bigint,
	grp varchar,
	type varchar,
	subtype varchar,
	url varchar,
	orgid varchar,
	formid varchar,
	code varchar,
	ltpa varchar,
	sudirresponse varchar,
	ymdh varchar
);