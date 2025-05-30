CREATE TABLE ALBUMS(
album_id		VARCHAR(40)						,
album_name		VARCHAR(60)		NOT NULL		,
release_date	DATE			NOT NULL		,
CONSTRAINT "ALB_PK_ALBUM_ID" PRIMARY KEY(album_id)
);

CREATE TABLE ARTISTS(
artist_id		SERIAL      					,
artist_name		VARCHAR(30)		NOT NULL		,
CONSTRAINT "ART_PK_ARTIST_ID" PRIMARY KEY(artist_id)
);

CREATE TABLE TRACKS(
track_id			VARCHAR(30)					,
track_name			VARCHAR(60)		NOT NULL	,
track_popularity	SMALLINT					,
duration_ms			INTEGER						,
danceability		DOUBLE PRECISION			,
energy				DOUBLE PRECISION			,
track_key			DOUBLE PRECISION			,
loudness			DOUBLE PRECISION			,
track_mode			BOOLEAN						,
speechiness			DOUBLE PRECISION			,
acousticness		DOUBLE PRECISION			,
instrumentalness	DOUBLE PRECISION			,
liveness			DOUBLE PRECISION			,
valence				DOUBLE PRECISION			,
tempo				DOUBLE PRECISION			,
artist_id			SERIAL						,
album_id			VARCHAR(40)					,
CONSTRAINT "TRA_PK_TRACK_ID" PRIMARY KEY(track_id)
);

CREATE TABLE PLAYLISTS(
playlist_id			VARCHAR(40)					,
playlist_name		VARCHAR(80)	NOT NULL		,
genre				VARCHAR(40)					,
subgenre			VARCHAR(40)					,
CONSTRAINT "PLA_PK_PLAYLIST_ID" PRIMARY KEY(playlist_id)
);

CREATE TABLE PLAYLIST_TRACKS(
track_id 			VARCHAR(30) 				,
playlist_id		 	VARCHAR(40) 				,
CONSTRAINT "PLT_PK" PRIMARY KEY (track_id, playlist_id)
);

ALTER TABLE TRACKS
    ADD CONSTRAINT "TRA_CHK_TRACK_POPULARITY" CHECK(track_popularity BETWEEN 0 AND 100),
    ADD CONSTRAINT "TRA_CHK_DANCEABILITY" CHECK(danceability BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_ENERGY" CHECK(energy BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_SPEECHINESS" CHECK(speechiness BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_ACOUSTICNESS" CHECK(acousticness BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_INSTRUMENTALNESS" CHECK(instrumentalness BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_LIVENESS" CHECK(liveness BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_VALENCE" CHECK(valence BETWEEN 0.0 AND 1.0),
    ADD CONSTRAINT "TRA_CHK_LOUDNESS" CHECK(loudness BETWEEN -60 AND 0),
    ADD CONSTRAINT "TRA_FK_ARTIST_ID" FOREIGN KEY (artist_id) REFERENCES ARTISTS(artist_id),
    ADD CONSTRAINT "TRA_FK_ALBUM_ID" FOREIGN KEY (album_id) REFERENCES ALBUMS(album_id);


ALTER TABLE PLAYLIST_TRACKS 
    ADD CONSTRAINT "PLT_FK_TRACK_ID" FOREIGN KEY (track_id) REFERENCES TRACKS(track_id),
    ADD CONSTRAINT "PLT_FK_PLAYLIST_ID" FOREIGN KEY (playlist_id) REFERENCES PLAYLISTS(playlist_id);

ALTER TABLE ARTISTS 
    ADD CONSTRAINT "ART_UQ_ARTIST_NAME" UNIQUE (artist_name);

COMMENT ON TABLE ALBUMS IS 'Tabla que almacena información de los álbumes musicales';
COMMENT ON TABLE ARTISTS IS 'Tabla que almacena información de los artistas musicales';
COMMENT ON TABLE TRACKS IS 'Tabla que almacena información de las canciones y sus características musicales';
COMMENT ON TABLE PLAYLISTS IS 'Tabla que almacena información de las listas de reproducción';
COMMENT ON TABLE PLAYLIST_TRACKS IS 'Tabla de relación entre canciones y listas de reproducción';

COMMENT ON COLUMN ALBUMS.album_id IS 'ID único del álbum';
COMMENT ON COLUMN ALBUMS.album_name IS 'Nombre del álbum de la canción';
COMMENT ON COLUMN ALBUMS.release_date IS 'Fecha de lanzamiento del álbum';

COMMENT ON COLUMN ARTISTS.artist_id IS 'ID único del artista';
COMMENT ON COLUMN ARTISTS.artist_name IS 'Nombre del artista de la canción';

COMMENT ON COLUMN TRACKS.track_id IS 'ID único de la canción';
COMMENT ON COLUMN TRACKS.track_name IS 'Nombre de la canción';
COMMENT ON COLUMN TRACKS.track_popularity IS 'Popularidad de la canción (0-100) donde mayor es mejor';
COMMENT ON COLUMN TRACKS.duration_ms IS 'Duración de la canción en milisegundos';
COMMENT ON COLUMN TRACKS.danceability IS 'La bailabilidad describe qué tan adecuada es una canción para bailar basándose en una combinación de elementos musicales incluyendo tempo, estabilidad del ritmo, fuerza del compás y regularidad general. Un valor de 0.0 es menos bailable y 1.0 es más bailable.';
COMMENT ON COLUMN TRACKS.energy IS 'La energía es una medida de 0.0 a 1.0 y representa una medida perceptual de intensidad y actividad. Típicamente, las canciones energéticas se sienten rápidas, fuertes y ruidosas. Por ejemplo, el death metal tiene alta energía, mientras que un preludio de Bach puntúa bajo en la escala. Las características perceptuales que contribuyen a este atributo incluyen rango dinámico, volumen percibido, timbre, tasa de inicio y entropía general.';
COMMENT ON COLUMN TRACKS.track_key IS 'La tonalidad general estimada de la canción. Los números enteros se mapean a tonos usando la notación estándar de Clase de Tono. Por ejemplo, 0 = C, 1 = C♯/D♭, 2 = D, y así sucesivamente. Si no se detectó ninguna tonalidad, el valor es -1.';
COMMENT ON COLUMN TRACKS.loudness IS 'El volumen general de una canción en decibelios (dB). Los valores de volumen se promedian a lo largo de toda la canción y son útiles para comparar el volumen relativo de las canciones. El volumen es la cualidad de un sonido que es el correlato psicológico principal de la fuerza física (amplitud). Los valores típicamente van entre -60 y 0 dB.';
COMMENT ON COLUMN TRACKS.track_mode IS 'El modo indica la modalidad (mayor o menor) de una canción, el tipo de escala de la cual se deriva su contenido melódico. Mayor está representado por 1 y menor por 0.';
COMMENT ON COLUMN TRACKS.speechiness IS 'La oralidad detecta la presencia de palabras habladas en una canción. Mientras más exclusivamente parecida al habla sea la grabación (por ejemplo, programa de entrevistas, audiolibro, poesía), más cerca de 1.0 estará el valor del atributo. Valores por encima de 0.66 describen canciones que probablemente están hechas completamente de palabras habladas. Valores entre 0.33 y 0.66 describen canciones que pueden contener tanto música como habla, ya sea en secciones o superpuestas, incluyendo casos como la música rap. Valores por debajo de 0.33 muy probablemente representan música y otras canciones no parecidas al habla.';
COMMENT ON COLUMN TRACKS.acousticness IS 'Una medida de confianza de 0.0 a 1.0 de si la canción es acústica. 1.0 representa alta confianza de que la canción es acústica.';
COMMENT ON COLUMN TRACKS.instrumentalness IS 'Predice si una canción no contiene voces. Los sonidos "Ooh" y "aah" se tratan como instrumentales en este contexto. Las canciones de rap o palabra hablada son claramente "vocales". Mientras más cerca esté el valor de instrumentalidad a 1.0, mayor es la probabilidad de que la canción no contenga contenido vocal. Valores por encima de 0.5 están destinados a representar canciones instrumentales, pero la confianza es mayor mientras el valor se acerca a 1.0.';
COMMENT ON COLUMN TRACKS.liveness IS 'Detecta la presencia de una audiencia en la grabación. Valores más altos de vivacidad representan una mayor probabilidad de que la canción haya sido interpretada en vivo. Un valor por encima de 0.8 proporciona una fuerte probabilidad de que la canción sea en vivo.';
COMMENT ON COLUMN TRACKS.valence IS 'Una medida de 0.0 a 1.0 que describe la positividad musical transmitida por una canción. Canciones con alta valencia suenan más positivas (por ejemplo, felices, alegres, eufóricas), mientras que canciones con baja valencia suenan más negativas (por ejemplo, tristes, deprimidas, enojadas).';
COMMENT ON COLUMN TRACKS.tempo IS 'El tempo general estimado de una canción en latidos por minuto (BPM). En terminología musical, el tempo es la velocidad o ritmo de una pieza dada y se deriva directamente de la duración promedio del latido.';
COMMENT ON COLUMN TRACKS.artist_id IS 'ID único del artista - Clave foránea que referencia a la tabla ARTISTS';
COMMENT ON COLUMN TRACKS.album_id IS 'ID único del álbum - Clave foránea que referencia a la tabla ALBUMS';

COMMENT ON COLUMN PLAYLISTS.playlist_id IS 'ID de la lista de reproducción';
COMMENT ON COLUMN PLAYLISTS.playlist_name IS 'Nombre de la lista de reproducción';
COMMENT ON COLUMN PLAYLISTS.genre IS 'Género de la lista de reproducción';
COMMENT ON COLUMN PLAYLISTS.subgenre IS 'Subgénero de la lista de reproducción';

COMMENT ON COLUMN PLAYLIST_TRACKS.track_id IS 'ID único de la canción - Clave foránea que referencia a la tabla TRACKS';
COMMENT ON COLUMN PLAYLIST_TRACKS.playlist_id IS 'ID de la lista de reproducción - Clave foránea que referencia a la tabla PLAYLISTS';

--PL

CREATE OR REPLACE FUNCTION GET_ARTIST_ID(V_ARTIST_NAME VARCHAR(40))
RETURNS INTEGER AS $$
DECLARE
V_ID INTEGER;
BEGIN
	SELECT ARTIST_ID
	INTO V_ID
	FROM ARTISTS
	WHERE ARTIST_NAME=V_ARTIST_NAME;
RETURN V_ID;
END;
$$ LANGUAGE plpgsql;

--SELECT GET_ARTIST_ID('AAA')