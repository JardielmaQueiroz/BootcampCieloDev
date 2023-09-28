create table pessoajuridica(

    id bigint not null auto_increment unique,
    cnpj varchar(14) not null unique,
    razao_social varchar(50) not null,
    mcc int not null,
    cpf varchar(11) not null,
    nome varchar(100) not null,
    email varchar(100) not null,
    ativo tinyint not null,
    primary key(id)

);