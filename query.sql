SELECT c.id, c.razao_social, t.numero
FROM Cliente c
INNER JOIN Telefone t ON c.id = t.idCliente
INNER JOIN Estado e ON c.estado = e.id
WHERE e.sigla = 'SP';