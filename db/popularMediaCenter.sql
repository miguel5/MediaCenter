USE mediaCenter;

INSERT INTO Utilizador (nome, email, password, admin) VALUES ('Zé Admin','zeadmin@gmail.com','pass1',1);
INSERT INTO Utilizador (nome, email, password, admin) VALUES ('Cristiano Ronaldo','cristianoronaldo@gmail.com','pass2',0);
INSERT INTO Utilizador (nome, email, password, admin) VALUES ('Bernardo Silva','bernardo silva@gmail.com','pass3',0);
INSERT INTO Utilizador (nome, email, password, admin) VALUES ('Bruno Lage','brunolage@gmail.com','pass4',0);
INSERT INTO Utilizador (nome, email, password, admin) VALUES ('Bruno Fernandes','brunofernandes@gmail.com','pass5',0);

INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('A garagem da Vizinha','/HOME/user/conteudo/','Quim Barreiros','Pimba',0);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Paranoid Android','/HOME/user/conteudo/','Radiohead','Rock Alternativo',0);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Jeremy','/HOME/user/conteudo/','Pearl Jam','Rock Alternativo',0);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Stairway to Heaven','/HOME/user/conteudo/','Led Zeppelin','Rock',0);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Videoclip da garagem da Vizinha','/HOME/user/conteudo/','Quim Barreiros','Pimba',1);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Videoclip Paranoid Android','/HOME/user/conteudo/','Radiohead','Rock Alternativo',1);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Videoclip Jeremy','/HOME/user/conteudo/','Pearl Jam','Rock Alternativo',1);	
INSERT INTO Conteudo (titulo, localizacao, artista, genero, tipo) VALUES ('Videoclip Stairway to Heaven','/HOME/user/conteudo/','Led Zeppelin','Rock',1);

INSERT INTO Utilizador_has_Conteudo VALUES (1,1);
INSERT INTO Utilizador_has_Conteudo VALUES (2,2);
INSERT INTO Utilizador_has_Conteudo VALUES (2,4);
INSERT INTO Utilizador_has_Conteudo VALUES (2,7);
INSERT INTO Utilizador_has_Conteudo VALUES (2,8);
INSERT INTO Utilizador_has_Conteudo VALUES (3,2);
INSERT INTO Utilizador_has_Conteudo VALUES (3,3);
INSERT INTO Utilizador_has_Conteudo VALUES (3,4);
INSERT INTO Utilizador_has_Conteudo VALUES (4,5);
INSERT INTO Utilizador_has_Conteudo VALUES (4,6);
INSERT INTO Utilizador_has_Conteudo VALUES (4,7);
INSERT INTO Utilizador_has_Conteudo VALUES (4,8);
INSERT INTO Utilizador_has_Conteudo VALUES (5,1);
INSERT INTO Utilizador_has_Conteudo VALUES (5,5);

INSERT INTO Playlist (nome, Utilizador_idUtilizador) VALUES ('Playlist do Cristi',2);
INSERT INTO Playlist (nome, Utilizador_idUtilizador) VALUES ('Playlist Led Zeppelin',2);

INSERT INTO Playlist_has_Conteudo VALUES (1,2);
INSERT INTO Playlist_has_Conteudo VALUES (1,4);
INSERT INTO Playlist_has_Conteudo VALUES (2,7);
INSERT INTO Playlist_has_Conteudo VALUES (2,8);

INSERT INTO Amigo VALUES (1,2);
INSERT INTO Amigo VALUES (1,3);
INSERT INTO Amigo VALUES (1,4);
INSERT INTO Amigo VALUES (1,5);
INSERT INTO Amigo VALUES (2,3);
INSERT INTO Amigo VALUES (2,4);
INSERT INTO Amigo VALUES (2,5);