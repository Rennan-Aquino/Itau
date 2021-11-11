insert into tb_pessoa
(id_usuario, cpf, nome, data_nascimento, rg, telefone, email, endereco, numero, complemento)
values (null, '48492335890', 'Andre Silva', '2000-11-22', '47283456', '11992831547', 'andre.silva@hotmail.com',
        'Rua Dos Almirantes', 220, 'Casa'),

       (null, '38442355680', 'Amanda Brandão', '1998-04-29', '6378288', '22992812756', 'amanda.bradao@gmail.com.br',
        'Rua Das Rosas', 10, 'Apartamento Bloco A'),

       (null, '28882399690', 'Lucas Souza', '1978-02-26', '47283456', '68982820666', 'lucas.souza@yahoo.com',
        'Av. Colorado', 33, 'Apartamento Bloco C'),

       (null, '39992329630', 'Helena de Souza', '1988-12-26', '27283456', '34926624666', 'helena.souza@gmail.com',
        'Av. Colorado', 433, 'Casa');

insert into tb_contrato
(id_contrato, data_inicio, data_final, quantidade_parcelas, valor_liquido, valor_bruto)
values (null, '2021-10-30', '2023-10-30', 4, 10000, 15000),
       (null, '2022-05-25', '2025-12-10', 10, 50000, 100000);
