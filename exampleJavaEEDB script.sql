create table roles(
id_role int(11) auto_increment
,name varchar(50) not null
,primary key (id_role) 
);

create table users(
id_user int(11) auto_increment
,login varchar(50) not null
,password text not null
,id_role int(11) not null
,date timestamp not null
,primary key (id_user)
);

alter table users add constraint users_roles 
foreign key (id_role) references roles (id_role);

create table topics(
id_topic int(11) auto_increment
,title varchar(255) not null
,content text not null
,date timestamp not null
,id_user int(11) not null
,primary key (id_topic)
);

alter table topics add constraint topics_users 
foreign key (id_user) references users(id_user);

create table registrations(
id_registration int(11) auto_increment
,content text not null
,date timestamp not null
,id_topic int(11) not null
,id_user int(11) not null
,primary key (id_registration)
);

alter table registrations add constraint registrations_topics 
foreign key (id_topic) references topics (id_topic);

alter table registrations add constraint registrations_users 
foreign key (id_user) references users (id_user);

insert into roles (name) values ('user');

insert into users (login, password, id_role, date) values ('jan','5f4dcc3b5aa765d61d8327deb882cf99',1,current_timestamp())
--5f4dcc3b5aa765d61d8327deb882cf99 it is a string = 'password'

--view for tomcat
create or replace view users_roles as select u.login "login", r.name "name" from users u, roles r where u.id_role = r.id_role


