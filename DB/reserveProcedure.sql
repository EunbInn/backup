use kopoctc;							#DB사용
drop procedure if exists resvstat_calc;	#프로시저 존재하면 삭제
delimiter $$
create procedure resvstat_calc()		#예약상황 계산하는 프로시져 생성
begin
	declare _date date;					#날짜 변수 선언
    declare _cnt integer;				#카운트 변수 선언
    declare _room1 varchar(20);			#방번호 1번 변수 문자열로 선언
    declare _room2 varchar(20);			#방번호 2번 변수 문자열로 선언
    declare _room3 varchar(20);			#방번호 3번 변수 문자열로 선언
    
    set _date = now();
    set _cnt = 0;
    ####################################예약상황 보여주는 table 만들기
    drop table if exists reserv_stat; 	#우선 테이블 삭제
    create table reserv_stat(
		reserve_date date not null,
        room1 varchar(20),
        room2 varchar(20),
        room3 varchar(20),
        primary key(reserve_date));		#p-key: 예약 날짜
        
	###################################table에 데이터 insert 하기위한 반복문
    # 예약일에 해당 방번호로 이름을 조회했을 때 0이면 예약 가능으로 셋팅, 0보다 크면 해당 이름으로 셋팅
    _loop: loop
		if (select count(name) from reservation where reserve_date=_date and room=1) = 0 then
			set _room1 = "예약가능";
        else
			set _room1 = (select name from reservation where reserve_date=_date and room=1);
		end if;
        
        if (select count(name) from reservation where reserve_date=_date and room=2) = 0 then
			set _room2 = "예약가능";
        else
			set _room2 = (select name from reservation where reserve_date=_date and room=2);
		end if;
        
        if (select count(name) from reservation where reserve_date=_date and room=3) = 0 then
			set _room3 = "예약가능";
        else
			set _room3 = (select name from reservation where reserve_date=_date and room=3);
		end if;
        
		#테이블에 인서트
        insert into reserv_stat values(_date, _room1, _room2, _room3);
     
        set _cnt = _cnt + 1;
        set _date = date_add(now(), interval +_cnt day);
        
        #시간의 지금으로부터 한달이 차이가 나면 반복문 탈출
        if TIMESTAMPDIFF(MONTH, now(), _date) = 1  then
			leave _loop;
		end if;
	end loop _loop;
end $$
delimiter ;

call resvstat_calc(); #프로시져 호출
select * from reserv_stat; #프로시저로 인서트한 데이터 확인

select count(name) from reservation where reserve_date="2021-06-10" and room=2