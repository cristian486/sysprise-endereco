create table estado(
    id bigint not null auto_increment,
    nome varchar(50) not null unique,
    codigo_ibge char(7) unique,
    sigla char(2) not null unique,
    constraint estadopk primary key(id)
);

create table cidade(
    id bigint not null auto_increment,
    nome varchar(125) not null unique,
    codigo_ibge char(7) unique,
    estado_id bigint,
    constraint cidadepk primary key(id),
    constraint cidade_estadofk foreign key(estado_id) references estado(id)
);

create table endereco(
    id bigint not null auto_increment,
    rua varchar(150) not null,
    numero integer not null,
    bairro varchar(100) not null,
    complemento varchar(200),
    cep char(8),
    cidade_id bigint,
    constraint enderecopk primary key(id),
    constraint endereco_cidadefk foreign key(cidade_id) references cidade(id)
);