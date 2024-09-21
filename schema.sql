CREATE TABLE Estado (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    sigla VARCHAR(2)
);

CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    razao_social TEXT,
    estado INT,
    FOREIGN KEY (estado) REFERENCES Estado(id)
);

CREATE TABLE Telefone (
    id INT PRIMARY KEY,
    idCliente INT,
    tipo VARCHAR(20),
    numero VARCHAR(11),
    FOREIGN KEY (idCliente) REFERENCES Cliente(id)
);