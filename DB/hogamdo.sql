use kopoctc;
drop table if exists hogamdo; #호감도 테이블 존재시 삭제 후 새로 생성
create table hogamdo(
	name varchar(20),
    age int);
    
desc hogamdo; # 구조 확인
    
drop procedure if exists input_data_twice; #데이터를 만들어주는 프로시져 
delimiter $$
create procedure input_data_twice(_last integer)
begin
declare _name varchar(20);
declare _age integer;
declare _cnt integer;
declare _rand integer;
set _cnt = 0;
delete from hogamdo where age > 0; #데이터가 존재하면 지우고 다시 생성
	_loop : loop
		set _cnt = _cnt + 1;
        set _rand = rand()*8 + 1; #랜덤으로 숫자를 발생시켜 조건에 따라 투표할 사람 고르기
		if _rand = 1 then  
				set _name = "나연";
			elseif _rand = 2 then 
				set _name = "정연";
			elseif _rand = 3 then 
				set _name = "사나";
			elseif _rand = 4 then
				set _name = "모모";
            elseif _rand = 5 then 
				set _name = "지효";
            elseif _rand = 6 then 
				set _name = "미나";
            elseif _rand = 7 then 
				set _name = "다현";
            elseif _rand = 8 then 
				set _name = "쯔위";
			elseif _rand = 9 then 
				set _name = "채영";
		end if;
		set _age = (rand()*8) + 1; # 1 ~ 9까지의 랜덤 숫자를 _age변수에 저장 
        insert into hogamdo value (_name, _age); #테이블에 데이터 삽입
        
        if _cnt = _last then
			leave _loop;
		end if;
	end loop _loop; #카운트가 인자로 받은 수와 같아지면 루프 종료
end $$
delimiter ;
set sql_safe_updates = 0; #세이프모드로 인해 데이터 업데이트가 되지 않아 실행시에만 off해줌
call input_data_twice(1000); #프로시저 호출하여 데이터 생성
select count(*) from hogamdo; #전체 데이터개수 조회
select * from hogamdo; #전체 데이터 조회

drop function if exists f_seonhodo; #선호도를 알려주는 함수
delimiter $$
create function f_seonhodo(_name varchar(20)) returns double
begin
declare _per double; #비율 저장할 변수 더블로 선언
	select count(name)/(select count(*) from hogamdo)*100
		into _per from hogamdo group by name having name = _name; 
return _per;#group by 절에서 따로 조건을 주는 having 사용하여 카운팅 및 선호도 계산 후 변수에 저장한 값리턴
end $$
delimiter ;

select name as 이름, count(*) as 득표수, f_seonhodo(name) as 선호도비율 
	from hogamdo group by name order by 선호도비율 desc; #이름, 득표수, 선호도 비율 셀렉하여  내림차순

