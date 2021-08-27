create table heroku_b4b0e6c1521538d.ingrediente(
	id_ingrediente int auto_increment primary key,
	nome_ingrediente VARCHAR (50)
);

create table heroku_b4b0e6c1521538d.categoria(
	id_categoria  int auto_increment primary key,
	nome_categoria VARCHAR (50)
);

create table heroku_b4b0e6c1521538d.receita(
	id_receita  int auto_increment primary key,
	nome_receita VARCHAR (80),
	tempo_preparo_receita int,
	serve_receita int,
	kcal_receita int,
	modo_preparo_receita longtext,
	url_receita varchar(1000),
	id_categoria int,
	FOREIGN KEY (id_categoria) REFERENCES heroku_b4b0e6c1521538d.categoria (id_categoria)
);

create table heroku_b4b0e6c1521538d.ingrediente_receita(
	id_ingrediente_receita  int auto_increment primary key,
	id_ingrediente int,
	id_receita int,
	FOREIGN KEY (id_ingrediente) REFERENCES heroku_b4b0e6c1521538d.ingrediente (id_ingrediente),
	FOREIGN KEY (id_receita) REFERENCES heroku_b4b0e6c1521538d.receita (id_receita)
);