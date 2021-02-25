/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet van deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.

 */

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO feedback_text(message) VALUES('Hey Oliver Heldens here! I really like the way you made the build-up in your song.');
INSERT INTO feedback_text(message) VALUES('Hey Oliver Heldens here! Although your chorus is great, i think it really misses some life during the build-up. I would advise you to add some more instruments.');
INSERT INTO feedback_text(message) VALUES('Hey Oliver Heldens here! I feel this is a song for my next radio show Heldeep. Please let us know if you give permission to be used on the radio show, and we will make it so!');
INSERT INTO feedback_text(message) VALUES('Hey Oliver Heldens here! This song is exactly what i am looking for! I want to register this song to Heldeep Records and make you a part of our family instantly!');
