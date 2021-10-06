use kopoctc; #데이터베이스 사용

drop table if exists reservation; #테이블이 존재하면 지움

#이름, 예약일, 방번호, 예약자 거주지, 전화번호, 입금자명, 메모, 예약폼 제출일로 테이블 생성
#p-key는 예약일과 방번호 두개의 멀티 키를 정함
create table reservation(
	name varchar(20),
    reserve_date date,
    room int,
    address varchar(100),
    tel varchar(20),
    ibgum_name varchar(20),
    memo varchar(300),
    input_date date,
    primary key(reserve_date, room)); 

desc reservation; #테이블 구조 조회

#임의 값 9개 집어넣고 조회
insert into reservation values ("나현", "2021-06-10",1,"서울","010-1234-1234", "나연", "뷰좋은 방으로 부탁해요",now());
insert into reservation values ("정연", "2021-06-14",2,"남양주","010-1234-1234", "정연", "뷰좋은 방으로 부탁해요",now());
insert into reservation values ("사나", "2021-06-13",3,"서울","010-1234-1234", "나연", "따뜻한 방 원해요",now());
insert into reservation values ("모모", "2021-06-15",2,"부산","010-1234-1234", "나연", "뷰좋은 방으로 부탁해요",now());
insert into reservation values ("미나", "2021-06-18",1,"일본","010-1234-1234", "미나", "뷰좋은 방으로 부탁해요",now());
insert into reservation values ("지효", "2021-06-20",2,"서울","010-1234-1234", "나연", "조식 맛있게 부탁드려요",now());
insert into reservation values ("다현", "2021-06-13",2,"서울","010-1234-1234", "다현", "뷰좋은 방으로 부탁해요",now());
insert into reservation values ("채영", "2021-06-10",3,"분당","010-1234-1234", "채영", "뷰좋은 방으로 부탁해요",now());
insert into reservation values ("쯔위", "2021-06-11",1,"서울","010-1234-1234", "쯔위", "뷰좋은 방으로 부탁해요",now());

select * from reservation;