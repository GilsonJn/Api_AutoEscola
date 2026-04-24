alter table instrucoes add ativo tinyint;
update instrucoes set ativo = 1;

create table cancelamento_instrucao(
    id bigint not null auto_increment,
    instrucao_id bigint not null,
    motivo varchar(100) not null,

    primary key (id),
    constraint fk_cancelamento_instrucao_id foreign key (instrucao_id) references instrucoes(id)
);