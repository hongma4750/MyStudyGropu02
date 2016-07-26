
//MemberTable

drop table membertable;
create table membertable(
	m_name varchar2(20) not null,
	m_id varchar2(20) primary key not null,
	m_pw varchar2(20) not null,
	m_age number(3) not null,
	m_admin number(1) not null,
	m_email varchar2(50) not null,
	m_phone1 number(3) not null,
	m_phone2 number(4) not null,
	m_phone3 number(4) not null,
	m_gender varchar2(1) not null
);

select * from membertable;
insert into membertable values('김홍민','admin','admin',26,0,'lovely4750@naver.com',010,4750,8078,'m');


//board
drop table board;
create table board(
	b_num number(5) primary key,
	b_pass varchar2(30) not null,
	m_name varchar2(20) not null,
	m_email varchar2(50) not null,
	b_title varchar2(50) not null,
	b_content varchar2(1000) not null,
	b_readcount number(4) default 0,
	b_writedate date default sysdate
);

drop sequence board_seq;
create sequence board_seq
start with 1 increment by 1;

insert into board (b_num,m_name,m_email,b_pass,b_title,b_content)
values(board_seq.nextval,'김홍민','lovely4750@naver.com','1234','안녕하세요1','안녕하세요1');
insert into board (b_num,m_name,m_email,b_pass,b_title,b_content)
values(board_seq.nextval,'admin','lovely4750@naver.com','1234','안녕하세요2','안녕하세요2');
insert into board (b_num,m_name,m_email,b_pass,b_title,b_content)
values(board_seq.nextval,'김간지','lovely4750@naver.com','1234','안녕하세요3','안녕하세요3');
insert into board (b_num,m_name,m_email,b_pass,b_title,b_content)
values(board_seq.nextval,'홍간지','lovely4750@naver.com','1234','안녕하세요4','안녕하세요4');

select * from board;