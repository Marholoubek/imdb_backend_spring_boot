-- Index on the 'tconst' column in the 'title_basics' table
CREATE INDEX idx_TitleBasics_tconst
    ON title_basics (tconst);

-- Index on the 'primary_title' column in the 'title_basics' table
CREATE INDEX idx_TitleBasics_primaryTitle
    ON title_basics (primary_title);


-- Index on the 'nconst' column in the 'name_basics' table
CREATE INDEX idx_NameBasics_nconst
    ON name_basics (nconst);

-- Index on the 'primary_name' column in the 'name_basics' table
CREATE INDEX idx_NameBasics_primaryName
    ON name_basics (primary_name);


CREATE VIEW V_MOVIE_DETAILS AS
SELECT
    tb.tconst,
    tb.primary_title,
    tb.original_title,
    tb.is_adult,
    tb.start_year,
    tb.end_year,
    tb.runtime_minutes,
    tt.name                                                                                                                                                         AS title_type,
    STUFF((SELECT ', ' + g.name FROM title_genres tg JOIN genres g ON tg.genre_id = g.genre_id WHERE tb.tconst = tg.tconst FOR XML PATH('')), 1, 2, '')             AS genres,
    STUFF((SELECT ', ' + d.primary_name FROM title_directors td JOIN name_basics d ON td.nconst = d.nconst WHERE tb.tconst = td.tconst FOR XML PATH('')), 1, 2, '') AS directors,
    STUFF((SELECT ', ' + w.primary_name FROM title_writers tw JOIN name_basics w ON tw.nconst = w.nconst WHERE tb.tconst = tw.tconst FOR XML PATH('')), 1, 2, '')   AS writers
FROM title_basics tb
         JOIN title_types tt ON tb.title_type_id = tt.title_type_id;



CREATE LOGIN backendLogin WITH PASSWORD = 'veryStrongPassword123';

USE IMDb_spring;
CREATE USER backendUser FOR LOGIN backendLogin;

CREATE ROLE backendRole;

GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO backendRole;

ALTER ROLE backendRole ADD MEMBER backendUser;

GRANT CREATE TABLE TO backendRole;
GRANT CONTROL ON SCHEMA::dbo TO backendRole;




ALTER TABLE title_basics
DROP CONSTRAINT FKj59nvhnmho259x1bp8p4xmfhp;

ALTER TABLE title_basics
    ADD CONSTRAINT FKj59nvhnmho259x1bp8p4xmfhp
        FOREIGN KEY (title_type_id)
            REFERENCES title_genres(tconst)
            ON DELETE CASCADE;

    