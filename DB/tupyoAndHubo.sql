use kopoctc;

drop table if exists hubo;
create table hubo(
	kiho int not null,
    name varchar(10),
    gongyak varchar(50),
    primary key(kiho),
    index(kiho));
desc hubo;

drop table if exists tupyo1;
create table tupyo1(
	kiho int,
    age int,
    foreign key(kiho) references hubo(kiho));
desc tupyo1;

delete from hubo where kiho>0; #테이블 내 존재하는 데이터 삭제 후 아래 값 insert
insert into hubo values (1, "나연", "정의사회 구현");
insert into hubo values (2, "정연", "모두 1억 줌");
insert into hubo values (3, "모모", "월화수목토토일");
insert into hubo values (4, "사나", "잠을 많이 잘 수 있는 세상");
insert into hubo values (5, "지효", "장바구니 모두 담아");
insert into hubo values (6, "미나", "노는게 젤 좋아");
insert into hubo values (7, "다현", "자는게 젤 좋아");
insert into hubo values (8, "채영", "적게 일하고 많이 벌자");
insert into hubo values (9, "쯔위", "얼굴이 복지");
select kiho as 기호, name as 성명, gongyak as 공약 from hubo; 	#각 값에 별칭을 주어 select

delete from tupyo1 where kiho>0; 							#프로시저 실행 전 tupyo1테이블 데이터 삭제
drop procedure if exists insert_tupyo;						#integer를 인자로 받는 프로시져 생성
delimiter $$
create procedure insert_tupyo(_limit integer)
begin
declare _cnt integer;										#_cnt변수 선언
set _cnt = 0;												#변수 초기화
	_loop: loop
		set _cnt = _cnt + 1;								#루프문에서 변수 + 1
        insert into tupyo1 value (rand()*8+1, rand()*8+1);	#테이블에 랜덤 수 insert
        if _cnt = _limit then
			leave _loop;									#_cnt변수가 인자로 받는
		end if;
	end loop _loop;
end $$
delimiter ;
call insert_tupyo(1000);
select kiho as 투표한기호, age as 투표자연령대 from tupyo1; #결과 select
select count(*) from tupyo1; #insert된 행수 출력
select kiho, count(*) from tupyo1 group by kiho; #기호로 묶어서 출력

#hubo테이블에 있는 기호를 외래키로 가지고 있는 tupyo 테이블을 가져와서 이름, 공약, 득표수 보여줌
select b.name, b.gongyak, count(a.kiho)
	from tupyo1 as a, hubo as b
    where a.kiho = b.kiho
    group by a.kiho; 
    
#셀렉트 안에 셀렉트를 사용하여 조인을 이용할 필요 없이 후보 테이블에 있는 값 가져옴
select
	(select name from hubo where kiho = a.kiho),
    (select gongyak from hubo where kiho = a.kiho),
    count(a.kiho)
    from tupyo1 as a
    group by a.kiho;
    
    
drop table if exists tupyo2; 			#한번에 세사람을 뽑은 테이블 생성
create table tupyo2(
	kiho1 int,
    kiho2 int,
    kiho3 int,
    age int);
desc tupyo2; 							#테이블 구조 확인

delete from tupyo2 where kiho1>0;		#테이블 내 데이터 삭제
drop procedure if exists insert_tupyo2;	#인티저 타입을 인자로 받는 프로시저 생성
delimiter $$
create procedure insert_tupyo2(_limit integer)
begin
declare _cnt integer;					#루프에서 쓰일 카운트 변수 선언
set _cnt = 0;							#카운트 초기화
	_loop: loop
		set _cnt = _cnt + 1;			#루프 돌며 변수 + 1, 테이블에 값 삽입
        insert into tupyo2 value (rand()*8+1, rand()*8+1, rand()*8+1, rand()*8+1);
        if _cnt = _limit then
			leave _loop;				#카운트가 인자로 받은 인티저 변수와 같아지면 루프탈출
		end if;
	end loop _loop;
end $$
delimiter ;
call insert_tupyo2(1000);				#프로시저 호출하여 투표 데이터 1000개 생성
select * from tupyo2;					#전체 조회
select count(*) from tupyo2;			#전체 데이터 행수 조회

#join 이용하여 기호를 이름으로 나타냄
select a.age, h1.name as 투표1, h2.name as 투표2, h3.name as 투표3
	from tupyo2 as a, hubo as h1, hubo as h2, hubo as h3
	where a.kiho1=h1.kiho and a.kiho2=h2.kiho and a.kiho3=h3.kiho;
 
#셀렉트 안에 셀렉트를 사용하여 기호를 이름으로 나타냄
select a.age,
	(select name from hubo where a.kiho1 = kiho) as "투표1",
    (select name from hubo where a.kiho2 = kiho) as "투표2",
	(select name from hubo where a.kiho3 = kiho) as "투표3"
    from tupyo2 as a;

#각 멤버에 투표한 사람 찾기
select
	(select count(*) from tupyo2 where kiho1=1 or kiho2=1 or kiho3=1) as "나연",
    (select count(*) from tupyo2 where kiho1=2 or kiho2=2 or kiho3=2) as "정연",
    (select count(*) from tupyo2 where kiho1=3 or kiho2=3 or kiho3=3) as "모모",
    (select count(*) from tupyo2 where kiho1=4 or kiho2=4 or kiho3=4) as "사나",
    (select count(*) from tupyo2 where kiho1=5 or kiho2=5 or kiho3=5) as "지효",
    (select count(*) from tupyo2 where kiho1=6 or kiho2=6 or kiho3=6) as "미나",
    (select count(*) from tupyo2 where kiho1=7 or kiho2=7 or kiho3=7) as "다현",
    (select count(*) from tupyo2 where kiho1=8 or kiho2=8 or kiho3=8) as "채영",
    (select count(*) from tupyo2 where kiho1=9 or kiho2=9 or kiho3=9) as "쯔위";

select
	(select count(*) from tupyo2 where kiho1=1 or kiho2=1 or kiho3=1) as "나연",
    (select count(*) from tupyo2 where kiho1=2 or kiho2=2 or kiho3=2) as "정연",
    (select count(*) from tupyo2 where kiho1=3 or kiho2=3 or kiho3=3) as "모모",
    (select count(*) from tupyo2 where kiho1=4 or kiho2=4 or kiho3=4) as "사나",
    (select count(*) from tupyo2 where kiho1=5 or kiho2=5 or kiho3=5) as "지효",
    (select count(*) from tupyo2 where kiho1=6 or kiho2=6 or kiho3=6) as "미나",
    (select count(*) from tupyo2 where kiho1=7 or kiho2=7 or kiho3=7) as "다현",
    (select count(*) from tupyo2 where kiho1=8 or kiho2=8 or kiho3=8) as "채영",
    (select count(*) from tupyo2 where kiho1=9 or kiho2=9 or kiho3=9) as "쯔위",
	(select 나연 + 정연 + 모모 + 사나 + 지효 + 미나 + 다현 + 채영 + 쯔위) as "총합",
    (select count(*) from tupyo2 where kiho1=kiho2 or kiho1=kiho3 or kiho2=kiho3) as "2중복",
    (select count(*) from tupyo2 where kiho1=kiho2 and kiho2=kiho3) as "3중복",
    (select 총합 + 2중복 + 3중복) as "합계";