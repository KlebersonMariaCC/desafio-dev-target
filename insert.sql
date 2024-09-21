INSERT INTO Estado (id, nome, sigla)
VALUES
    (1, 'São Paulo', 'SP'),
    (2, 'Rio de Janeiro', 'RJ'),
    (3, 'Minas Gerais', 'MG'),
    (4, 'Bahia', 'BA'),
    (5, 'Pernambuco', 'PE');

INSERT INTO Cliente (id, razao_social, estado)
VALUES
    (1, 'Empresa A - Tecnologia', 1),
    (2, 'Empresa B - Varejo', 2),
    (3, 'Pessoa Física - João Silva', 3),
    (4, 'Empresa C - Serviços', 4),
    (5, 'Associação X', 5);
    

INSERT INTO Telefone (id, idCliente, tipo, numero)
VALUES
    (1, 1, 'Celular', '11987654321'),
    (2, 1, 'Comercial', '1134567890'),
    (3, 2, 'Celular', '21987654321'),
    (4, 2, 'Fixo', '2134567890'),
    (5, 3, 'Celular', '71987654321')
;