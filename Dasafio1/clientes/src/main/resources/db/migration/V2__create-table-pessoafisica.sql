create table pessoafisica(

    id bigint not null auto_increment unique,
    nome varchar(100) not null,
    email varchar(100) not null,
    cpf varchar(11) not null unique,
    mcc int not null,
    ativo tinyint not null,
    primary key(id)

);