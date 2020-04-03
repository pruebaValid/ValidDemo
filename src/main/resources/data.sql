DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  apellido VARCHAR(250) NOT NULL,
  procesado BOOLEAN DEFAULT FALSE
);


INSERT INTO usuario (nombre, apellido) VALUES
  ('Jesus', 'Lozano'),
  ('Dora', 'Tamayo');

