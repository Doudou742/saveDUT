
drop table if exists abonne, creneau, terrain, reservation;

Create table abonne(
       id_abonne Integer primary key not null,
       nom_abonne varchar(80) not null,
       id_parrain Integer references abonne(id_abonne) on update cascade on DELETE restrict
);

Create table creneau(
       dateCreneau date not null,
       heureCreneau TIME not null,
       Constraint pk_creneau primary key (dateCreneau,heureCreneau) 
);

Create table terrain(
       id_terrain Integer primary key not null,
       type_terrain varchar(15),
       nom_terrain varchar(20) 
);

Create table reservation(
       id_terrain Integer not null,
       id_abonne_responsable Integer not null,
       id_abonne_participant Integer not null,
       dateCreneau date not null,
       heureCreneau time not null,
       actif Integer,
       Constraint fk_id_terrain foreign key (id_terrain) references terrain (id_terrain) on update cascade on DELETE restrict,
       Constraint fk_id_respondable foreign key (id_abonne_responsable) references abonne (id_abonne) on update cascade on DELETE restrict,
       Constraint fk_id_participant foreign key (id_abonne_participant) references abonne (id_abonne) on update cascade on DELETE restrict,
       Constraint fk_date_heure_Creneau foreign key (dateCreneau,heureCreneau) references creneau(dateCreneau,heureCreneau) on update cascade on DELETE restrict,
       primary key (id_terrain,id_abonne_responsable,id_abonne_participant,dateCreneau,heureCreneau)
);


insert into abonne values (1,'geoffrey',null);
insert into abonne values (2,'marin',1);
insert into abonne values (3,'lucas',null);
insert into creneau values ('2017-09-12','16:30:00');
insert into creneau values ('2017-09-21','17:00:00');
insert into terrain values (1,'tennis','t1');
insert into terrain values (2,'badminton','b1');
insert into terrain values (3,'squash','s1');
insert into reservation values (1,1,2,'2017-09-12','16:30:00',1);
insert into reservation values (2,2,3,'2017-09-21','17:00:00',1);





