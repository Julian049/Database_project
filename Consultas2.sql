--Obtener todas las pistas de un artista específico
Select track_name Cancion, album_name Album
From tracks t 
JOIN artists a ON t.artist_id=a.artist_id
JOIN albums al ON t.album_id=al.album_id
WHERE UPPER(a.artist_name)=UPPER('Bad bunny')

--Pistas más populares de un género determinado
SELECT t.track_name NOMBRE, 
t.track_popularity POPULARIDAD
FROM playlist_tracks pt
JOIN tracks t ON t.track_id=pt.track_id
JOIN playlists p ON p.playlist_id=pt.playlist_id
WHERE UPPER(p.genre) = UPPER('rap')
ORDER BY t.track_popularity DESC

--Número de canciones que tiene un artista ordenados de mayor a menor
SELECT artist_name Artista,
count(t.track_id) Total_canciones
FROM artists a
JOIN tracks t ON a.artist_id=t.artist_id
GROUP BY artist_name
ORDER BY Total_canciones DESC

--Canciones lanzadas entre 2 fechas
SELECT track_name CANCION,
artist_name Artista
FROM tracks t
JOIN albums a ON t.album_id=a.album_id
JOIN artists ar ON t.artist_id=ar.artist_id
WHERE a.release_date BETWEEN '2020-01-01' AND '2020-12-31'
ORDER BY a.release_date

--popularidad promedio de los albums, ordenados de forma descendente
SELECT album_name album,
ROUND(AVG(t.track_popularity), 2) popularidad_promedio
FROM albums a
JOIN tracks t ON t.album_id=a.album_id
GROUP BY album_name
ORDER BY popularidad_promedio DESC

--Cancion mas popular de cada artista
SELECT DISTINCT ON (ar.artist_id) ar.artist_name Artista, 
t.track_name Cancion,
t.track_popularity Popularidad
FROM TRACKS t
JOIN ARTISTS ar ON t.artist_id = ar.artist_id
ORDER BY ar.artist_id, t.track_popularity DESC;

--Canciones bailables (energia y danceabilidad por encima de 0.8)
SELECT track_name Cancion, 
energy, 
danceability
FROM TRACKS
WHERE energy > 0.8 AND danceability > 0.8
ORDER BY energy DESC, danceability DESC;

--Validar que una pista tenga duración > 0
CREATE OR REPLACE FUNCTION validar_duracion()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.duration_ms <= 0 THEN
        RAISE EXCEPTION 'La duración debe ser mayor que 0';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_validar_duracion
BEFORE INSERT OR UPDATE ON TRACKS
FOR EACH ROW
EXECUTE FUNCTION validar_duracion();

--Duracion total de un album en minutos
CREATE OR REPLACE FUNCTION total_duracion_album(album_input_name VARCHAR)
RETURNS NUMERIC AS $$
DECLARE
    total_ms INTEGER;
BEGIN
    SELECT SUM(duration_ms) INTO total_ms
    FROM TRACKS t
	JOIN albums a ON a.album_id=t.album_id
    WHERE UPPER(album_name) = UPPER(album_input_name);

    RETURN ROUND((total_ms / 60000.0), 2);
END;
$$ LANGUAGE plpgsql;

SELECT total_duracion_album('sos');

select * from albums

--Auditoria de la tablas tracks
CREATE TABLE AUDITORIA_TRACKS (
    audit_id        SERIAL PRIMARY KEY,
    track_id        VARCHAR(30),
    track_name      VARCHAR(150),
    track_popularity SMALLINT,
    duration_ms     INTEGER,
    artist_id       VARCHAR(40),
    album_id        VARCHAR(40),
    operacion       VARCHAR(10),
    fecha_evento    TIMESTAMP DEFAULT NOW()
);

CREATE OR REPLACE FUNCTION auditar_tracks()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'DELETE' THEN
        INSERT INTO AUDITORIA_TRACKS (track_id, track_name, track_popularity, duration_ms, artist_id, album_id, operacion)
        VALUES (OLD.track_id, OLD.track_name, OLD.track_popularity, OLD.duration_ms, OLD.artist_id, OLD.album_id, 'DELETE');
        RETURN OLD;

    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO AUDITORIA_TRACKS (track_id, track_name, track_popularity, duration_ms, artist_id, album_id, operacion)
        VALUES (OLD.track_id, OLD.track_name, OLD.track_popularity, OLD.duration_ms, OLD.artist_id, OLD.album_id, 'UPDATE');
        RETURN NEW;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_auditar_tracks
AFTER UPDATE OR DELETE ON TRACKS
FOR EACH ROW
EXECUTE FUNCTION auditar_tracks();

DELETE FROM TRACKS WHERE track_id = '3sHuIjfAzluc6S9cXoqfqC';
UPDATE TRACKS SET track_popularity = 23 WHERE track_id = '3sHuIjfAzluc6S9cXoqfqC';

select * from auditoria_tracks