select 'SELECT * FROM '||TABLE_NAME||';' from all_tables where owner = 'BREWER' ORDER BY TABLE_NAME;

SELECT * FROM CERVEJA;
SELECT * FROM CIDADE;
SELECT * FROM CLIENTE;
SELECT * FROM ESTADO;
SELECT * FROM ESTILO;
SELECT * FROM GRUPO;
SELECT * FROM GRUPO_PERMISSAO;
SELECT * FROM ITEM_VENDA;
SELECT * FROM PERMISSAO;
SELECT * FROM USUARIO;
SELECT * FROM USUARIO_GRUPO;
SELECT * FROM VENDA;


SELECT * FROM USUARIO where email = 'admin@brewer.com';
SELECT * FROM USUARIO_GRUPO;
SELECT * FROM GRUPO;
SELECT * FROM PERMISSAO;
SELECT * FROM GRUPO_PERMISSAO;


insert into PERMISSAO (codigo,nome) values (permissao_seq.nextval,'ROLE_CADASTRAR_CIDADE');
insert into PERMISSAO (codigo,nome) values (permissao_seq.nextval,'ROLE_CADASTRAR_USUARIO');
insert into PERMISSAO (codigo,nome) values (permissao_seq.nextval,'ROLE_CANCELAR_VENDA');
insert into grupo (codigo, nome) values (grupo_seq.nextval, 'Administrador');
insert into grupo (codigo, nome) values (grupo_seq.nextval, 'Vendedor');
insert into grupo_permissao (codigo_grupo, codigo_permissao) values (1,1);
insert into grupo_permissao (codigo_grupo, codigo_permissao) values (1,2);
insert into grupo_permissao (codigo_grupo, codigo_permissao) values (1,3);
insert into usuario (codigo,ativo,data_nascimento,email,nome,senha) values (usuario_seq.nextval, 1, '23/01/1980','admin@brewer.com', 'admin','$2a$10$g.wT4R0Wnfel1jc/k84OXuwZE02BlACSLfWy6TycGPvvEKvIm86SG' );
insert into usuario_grupo (1,1);

