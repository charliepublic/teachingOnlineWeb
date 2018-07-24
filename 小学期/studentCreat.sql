create table project
(
	Pnumber varchar(20),
    Pname varchar(30),
    UpTime date,
    Info varchar(255),
    primary key(Pnumber) 
);

create table class
(
	Cnumber int,
	Cname varchar(20),
    primary key(Cnumber)    
);

create table teacher
(
	Tnumber varchar(20),
    Tname varchar(20),
    Tpass varchar(20),
    Cnumber int,
    primary key(Tnumber),
    foreign key(Cnumber) references class(Cnumber)
);

create table team 
(
	Gnumber int,
    Gname varchar(20) not null,
    Gleader varchar(20) not null,
    Cnumber int not null,
    Pnumber varchar(20) not null,
    primary key(Gnumber),
    foreign key(Cnumber) references class(Cnumber),
    foreign key(Pnumber) references project(Pnumber)
);




create table rootManage
( 
	Rnumber varchar(20),
    Rname varchar(20),
    Rpass varchar(20),
    Gnumber int,
    Cnumber int,
    Pnumber varchar(20),
    Tnumber varchar(20),
    primary key (Rnumber),
    foreign key(Gnumber) references team (Gnumber),
    foreign key(Cnumber) references class(Cnumber),
    foreign key(Pnumber) references project(Pnumber),
    foreign key(Tnumber) references Teacher(Tnumber)
);




create table file_lib
(
	filename varchar(20),
    furl varchar(255),
    Snumber varchar(20),
    Tnumber varchar(20),
    Pnumber varchar(20),
    grand double(3,1),
    primary key (furl),
	foreign key(Pnumber) references project(Pnumber),
    foreign key(Tnumber) references Teacher(Tnumber)
);


create table class_project
(
	Cumber int,
    Pnumber varchar(20)
);

create table student 
(
	Snumber varchar(20),
    Sname varchar(20),
    Spass varchar(20),
    Gnumber int,
    Cnumber int,
    Pnumber varchar(20),
    Tnumber varchar(20),
    primary key (Snumber),
    foreign key(Gnumber) references team (Gnumber),
    foreign key(Cnumber) references class(Cnumber),
    foreign key(Pnumber) references project(Pnumber),
    foreign key(Tnumber) references Teacher(Tnumber)
);
