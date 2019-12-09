USE mediaCenter;

INSERT INTO Utilizador VALUES (1,'Zé Admin','zeadmin@gmail.com','pass1',1);
INSERT INTO Utilizador VALUES (2,'Cristiano Ronaldo','cristianoronaldo@gmail.com','pass2',0);
INSERT INTO Utilizador VALUES (3,'Bernardo Silva','bernardo silva@gmail.com','pass3',0);
INSERT INTO Utilizador VALUES (4,'Bruno Lage','brunolage@gmail.com','pass4',0);
INSERT INTO Utilizador VALUES (5,'Bruno Fernandes','brunofernandes@gmail.com','pass5',0);

INSERT INTO Conteudo VALUES (1,'A garagem da Vizinha','/HOME/user/conteudo/','Quim Barreiros','Pimba',0);	
INSERT INTO Conteudo VALUES (2,'Paranoid Android','/HOME/user/conteudo/','Radiohead','Rock Alternativo',0);	
INSERT INTO Conteudo VALUES (3,'Jeremy','/HOME/user/conteudo/','Pearl Jam','Rock Alternativo',0);	
INSERT INTO Conteudo VALUES (4,'Stairway to Heaven','/HOME/user/conteudo/','Led Zeppelin','Rock',0);	
INSERT INTO Conteudo VALUES (5,'Videoclip da garagem da Vizinha','/HOME/user/conteudo/','Quim Barreiros','Pimba',1);	
INSERT INTO Conteudo VALUES (6,'Videoclip Paranoid Android','/HOME/user/conteudo/','Radiohead','Rock Alternativo',1);	
INSERT INTO Conteudo VALUES (7,'Videoclip Jeremy','/HOME/user/conteudo/','Pearl Jam','Rock Alternativo',1);	
INSERT INTO Conteudo VALUES (8,'Videoclip Stairway to Heaven','/HOME/user/conteudo/','Led Zeppelin','Rock',1);

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

INSERT INTO Playlist VALUES (1,'Playlist do Cristi',2);
INSERT INTO Playlist VALUES (2,'Playlist Led Zeppelin',2);

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