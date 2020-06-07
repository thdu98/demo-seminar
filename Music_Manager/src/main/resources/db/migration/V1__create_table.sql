CREATE TABLE musician(
id_musician INT AUTO_INCREMENT,
CONSTRAINT pk_id_musician PRIMARY KEY (id_musician),
name_musician VARCHAR(45)
);

CREATE TABLE song (
id_song INT AUTO_INCREMENT,
CONSTRAINT pk_id_song PRIMARY KEY(id_song),
name_song VARCHAR(45) NOT NULL,
kind_music VARCHAR(45) NOT NULL,
compose_date DATE NOT NULL,
publish_date DATE NOT NULL,
id_musician INT NOT NULL,
FOREIGN KEY (id_musician) REFERENCES musician(id_musician)
ON DELETE CASCADE
ON UPDATE CASCADE
);



CREATE table singer (
id_singer INT AUTO_INCREMENT,
CONSTRAINT pk_id_singer PRIMARY KEY (id_singer),
name_singer VARCHAR(45) NOT NULL
);
 

CREATE table sing (
id_sing INT AUTO_INCREMENT,
CONSTRAINT pk_id_sing PRIMARY KEY (id_sing),
id_song INT NOT NULL,
id_singer INT NOT NULL,
FOREIGN KEY (id_singer) REFERENCES singer (id_singer),
FOREIGN KEY (id_song) REFERENCES song (id_song)
ON DELETE CASCADE
ON UPDATE CASCADE
);
