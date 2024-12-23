drop table member;

/** 테이블 생성 */
create table member (
	id		int		auto_increment primary key,
    name	varchar(255)	not null,
    addr varchar(255),
    sdate	datetime
);

show tables;
select * from member;


insert into member (name, addr, sdate)
values ('spring', '아산시 용화동', now());

select * from member;


# Dwitter ---------------
# add address column
alter table dwitter
add column address varchar(255);

select * from dwitter;

insert into dwitter( name, message, image, sdate)
values('qwer', '집 가고 싶다', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8i4zPog-0j0JR_yZglxPhTPZXxN2iMTQ3Dw&s', now());

#------------
use hrdb_spring;
select database();
show tables;
desc dwitter;