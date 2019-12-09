USE mediaCenter;
DROP DATABASE mediaCenter;
-- Retorna todos os utilizadores
SELECT * FROM Utilizador;

-- Retorna a password para um dado utilizador dado o email
SELECT password FROM Utilizador
WHERE email='zeadmin@gmail.com';

-- Retorna todos os mp3 existentes
SELECT titulo FROM Conteudo
WHERE tipo = 0;

-- Retorna todos os videos existentes
SELECT titulo FROM Conteudo
WHERE tipo = 1;

-- Retorna o conteúdo de um dado utilizador
SELECT c.Titulo FROM Utilizador u
JOIN Utilizador_has_Conteudo uc ON u.idUtilizador = uc.Utilizador_idUtilizador
JOIN Conteudo c ON uc.Conteudo_idConteudo = c.idConteudo
WHERE u.nome = 'Cristiano Ronaldo';

-- Retorna as playlists de um dado utilizador
SELECT p.nome FROM Utilizador u
JOIN Playlist p ON u.idUtilizador = p.Utilizador_idUtilizador
WHERE u.nome = 'Cristiano Ronaldo';

-- Retorna os amigos de um dado utilizador
SELECT uu.nome FROM Utilizador u
JOIN Amigo a ON u.idUtilizador = a.idUtilizador
JOIN Utilizador uu ON a.idAmigo = uu.idUtilizador
WHERE u.nome = 'Cristiano Ronaldo';

-- retorna os utilizadores q têm o mesmo mp3 que um dado utilizador

SELECT u.nome FROM Utilizador u
JOIN Utilizador_has_Conteudo uc ON u.idUtilizador = Utilizador_idUtilizador
JOIN Conteudo c ON c.idConteudo = uc.Conteudo_idConteudo
WHERE u.nome <> 'Cristiano Ronaldo' && c.titulo = 'Paranoid Android';
 
