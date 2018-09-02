create database bd2;

use bd2;


select * from cd;

select * from Vhs;


create table cd(
idc int,
tipo varchar(50),
primary key (idc)
);

create table Vhs(
idv int,
tipo varchar (50),
primary key (idv)
);


alter table vhs add foreign key (idv) references cd ( idc );

drop table Vhs;
drop table cd;

select * from cd inner join vhs on vhs.idv;


