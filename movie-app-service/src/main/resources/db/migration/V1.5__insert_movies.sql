INSERT INTO movies (id, title, year, director)
VALUES('1', 'Pulp Fiction', '1994', 'Q. Tarantino');

INSERT INTO movies (id, title, year, director)
VALUES('2', 'Django Unchained', '2012', 'Q. Tarantino');

INSERT INTO movies (id, title, year, director)
VALUES('3', 'Once Upon a Time in Hollywood', '2019', 'Q. Tarantino');

INSERT INTO movies (id, title, year, director)
VALUES('4', 'Kill Bill: Vol. 1', '2003', 'Q. Tarantino');

INSERT INTO movies (id, title, year, director)
VALUES('5', 'Kill Bill: Vol. 2', '2003', 'Q. Tarantino');

DROP SEQUENCE movies_id_seq;
CREATE SEQUENCE movies_id_seq START WITH 6 INCREMENT BY 1;
