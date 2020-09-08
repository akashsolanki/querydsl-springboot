DROP TABLE item IF EXISTS;
DROP TABLE category IF EXISTS;


CREATE TABLE item (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30)
);
CREATE INDEX item_name ON item (name);

CREATE TABLE category (
  id   INTEGER IDENTITY PRIMARY KEY,
  item_id INTEGER NOT NULL,
  priority INTEGER,
  active BOOLEAN
);
