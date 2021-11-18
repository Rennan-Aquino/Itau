insert into tb_pessoa
(id_pessoa, cpf, nome, data_nascimento, rg, telefone, email)
values (null, '48492335890', 'Andre Silva', '2000-11-22', '47283456', '11992831547', 'andre.silva@hotmail.com'),

       (null, '38442355680', 'Amanda Brandão', '1998-04-29', '6378288', '22992812756', 'amanda.bradao@gmail.com.br'),

       (null, '28882399690', 'Lucas Souza', '1978-02-26', '47283456', '68982820666', 'lucas.souza@yahoo.com'),

       (null, '18882399690', 'Mauricio de Souza', '1968-01-26', '17283456', '18982820999', 'mauricio.souza@yahoo.com'),

       (null, '39992329630', 'Helena de Souza', '1988-12-26', '27283456', '34926624666', 'helena.souza@gmail.com');

insert into tb_contrato
(id_contrato, data_inicio, data_final, quantidade_parcelas, valor_liquido,id_pessoa, valor_bruto)
values (50, '2021-10-30', '2023-10-30', 4, 10000,1, 15000),
       (51, '2022-03-20', '2023-12-10', 2, 20000,2,50000),
       (52, '2022-06-05', '2027-05-17', 8, 30000,3,90000),
       (53, '2022-05-10', '2027-02-20', 6, 20000,4,70000),
       (54, '2022-12-15', '2029-11-10', 12, 90000,5,210000);

insert into tb_endereco
(id_endereco, logradouro, cidade, estado, pais, id_pessoa, complemento, numero)
values (null, 'Rua das Rosas', 'Campinas', 'São Paulo', 'Brasil',1,'Casa', 12),

       (null, 'Av. Francisco Matarazzo', 'Água Branca', 'São Paulo', 'Brasil',2,'Apartamento Bloco C', 42),

       (null, 'Barra da Tijuca', 'Rio de Janeiro', 'Rio de Janeiro', 'Brasil',3,'Apartamento Ala B', 16),

       (null, 'Alphaville 11', 'Barueri', 'São Paulo', 'Brasil',4, 'Condominio', 233),

       (null, 'Av. Alpina', 'Nova Lima', 'Minas Gerais', 'Brasil',5, 'Casa', 112);