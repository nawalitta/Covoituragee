insert into utilisateur (login,password,hasVoiture) values ('admin','admin',FALSE);
insert into utilisateur (login,password,hasVoiture) values   ('toto','toto',FALSE);
insert into utilisateur (login, password, hasVoiture, numeroTel, nomComplet, mail) values ('safae','safae123',FALSE, '+33787427958','SAFAE EL ATLA', 'elatlasafae@gmail.com');
insert into utilisateur (login, password, hasVoiture, numeroTel, nomComplet, mail) values ('nawal','nawal123',FALSE, '+33634567899','NAWAL ZAKRI', 'zakri.nawal@gmail.com');

insert into  ville (idville ,labelville) VALUES (1,'Paris'); 
insert into  ville (idville , labelville) VALUES (2,'Orléans') ;
insert into  ville (idville ,labelville) VALUES (3,'Bourges') ; 
insert into  ville (idville ,labelville) VALUES (4,'Lille') ; 
insert into  ville (idville ,labelville) VALUES (5,'Toulouse') ;
insert into  ville (idville ,labelville) VALUES (6,'Nantes'); 
insert into  ville (idville ,labelville) VALUES (7,'Rennes') ; 
insert into  ville (idville ,labelville) VALUES (8,'Bordeaux') ;  
insert into  ville (idville ,labelville) VALUES (9,'Marseille') ; 
insert into  ville (idville ,labelville) VALUES (10,'Strasbourg') ; 
insert into  ville (idville ,labelville) VALUES (11,'Nice') ; 
insert into  ville (idville ,labelville) VALUES (12,'Lyon') ;
insert into  ville (idville ,labelville) VALUES (13,'Toulon'); 
insert into  ville (idville ,labelville) VALUES (14,'Reims') ;
insert into  ville (idville ,labelville) VALUES (15,'Montpellier') ;
insert into  ville (idville ,labelville) VALUES (16,'Angers') ; 
insert into  ville (idville ,labelville) VALUES (17,'Limoges') ;
insert into  ville (idville ,labelville) VALUES (18,'Grenoble') ; 
insert into  ville (idville ,labelville) VALUES (19,'Dijon') ; 
insert into  ville (idville ,labelville) VALUES (20,'Caen') ;
insert into  ville (idville ,labelville) VALUES (21,'Tours') ;
insert into  ville (idville ,labelville) VALUES (22,'Clermont-Ferrand') ;


insert into gabarit(libelleGabarit) VALUES ('urbaine') ;
insert into gabarit(libelleGabarit) VALUES ('compacte') ;
insert into gabarit(libelleGabarit) VALUES ('SUV') ;
insert into gabarit(libelleGabarit) VALUES ('break') ;
insert into gabarit(libelleGabarit) VALUES ('routière') ;
insert into gabarit(libelleGabarit) VALUES ('fourgonnette') ;

insert into voiture (modele,proprietaire_voiture,gabarit_id) VALUES ('BMW','safae',1) ;

insert into trajet  VALUES (0,'2017-12-03','07:00',2,4,40,'safae',3,4) ;

insert into trajet  VALUES (1,'2017-12-30','09:00',1,4,24,'safae',3,4) ;
insert into trajet  VALUES (2,'2017-12-30','15:00',0,4,23,'safae',3,4) ;
insert into trajet  VALUES (3,'2017-12-30','21:00',3,4,45,'safae',3,4) ;

insert into trajet  VALUES (4,'2017-12-30','21:00',4,4,33,'safae',3,4) ;
insert into trajet  VALUES (5,'2017-12-31','17:00',2,4,45,'safae',3,4) ;
insert into trajet  VALUES (6,'2017-12-30','11:00',1,4,60,'safae',3,4) ; 





