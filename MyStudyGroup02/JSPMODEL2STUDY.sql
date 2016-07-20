
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