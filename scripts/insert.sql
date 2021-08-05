insert into clickfoodapi.ingrediente (nome_ingrediente) values ('ovo');
insert into clickfoodapi.ingrediente (nome_ingrediente) values ('sal');
insert into clickfoodapi.ingrediente (nome_ingrediente) values ('tomate');
insert into clickfoodapi.ingrediente (nome_ingrediente) values ('cebola');
insert into clickfoodapi.ingrediente (nome_ingrediente) values ('coentro');

insert into clickfoodapi.categoria (nome_categoria) values ('Omelete');
insert into clickfoodapi.categoria (nome_categoria) values ('Bolo');

insert into clickfoodapi.receita (nome_receita, tempo_preparo_receita, serve_receita, 
kcal_receita, modo_preparo_receita, url_receita, id_categoria) values ('Omelete simples', 10, 1, 100, 'teste', null, 1);

insert into clickfoodapi.ingrediente_receita (id_ingrediente, id_receita) values (1, 1);
insert into clickfoodapi.ingrediente_receita (id_ingrediente, id_receita) values (2, 1);

