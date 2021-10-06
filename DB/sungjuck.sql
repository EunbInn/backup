use kopoctc;
SET GLOBAL log_bin_trust_function_creators = 1; 											#함수 만들어지지 않는 오류로 함수 생성자 true로 변경

drop function if exists getReport; 															#함수 존재하면 지우기
delimiter $$
create function getReport (_id integer) returns boolean										#함수 생성: 인자: id, 반환값: boolean
begin
	declare _kor, _eng, _mat integer;														#국영수 숫자로 변수 선언
    declare _name varchar(20);																#학생 이름 문자열로 변수 선언
	select stu_name into _name from Scoring where stu_id = _id and subjectID = 1;			#id가 인자로 받은 id와 같고 과목번호가 1과 같은 곳의 이름을 _name에 저장
    select score into _kor from Scoring where stu_id = _id and subjectID = 1;				#id가 인자로 받은 id와 같고 과목번호가 1과 같은 곳의 점수를 국어로 저장
    select score into _eng from Scoring where stu_id = _id and subjectID = 2;				#id가 인자로 받은 id와 같고 과목번호가 2과 같은 곳의 점수를 영어로 저장
    select score into _mat from Scoring where stu_id = _id and subjectID = 3;				#id가 인자로 받은 id와 같고 과목번호가 3과 같은 곳의 점수를 수학으로 저장
    insert into Reporttable values(_name, _id, _kor, _eng, _mat);							#리포트 테이블에 데이터 insert
    return true;																			#true 값 리턴
end $$
delimiter ;
delete from Reporttable where stu_id > 0;													#function 돌리기 전 테이블 데이터 삭제
select getReport(stu_id) from Scoring where subjectID = 1;									#id중복 없이 집어넣기 위해 과목번호 지정하여 id조회 및 function 호출
select * from Reporttable;																	#insert 되었는지 조회

select *, (kor+eng+mat) as sum, (kor+eng+mat)/3 as ave,
	(select count(ave) + 1 from Reporttable as b where (a.kor+a.eng+a.mat) < (b.kor+b.eng+b.mat)) as ranking 
    from Reporttable as a order by ranking;													#국영수, 합계, 평균, 등수 출력

###########################################################################################
drop procedure if exists report2;						#프로시저 생성 전 지우기
delimiter $$
create procedure report2()								#프로시저 생성
begin
declare _cnt integer;									#과목 번호 세어줄 _cnt 변수 선언

drop table if exists reportQuestion;					#테이블 생성 p-key는 과목번호와 문제 번호
create table reportQuestion (
	subjectID integer not null,
    questionID varchar(10) not null,
    count integer,
    percentage double,
    primary key(subjectID, questionID));
    
    set _cnt = 0;										#_cnt변수 0으로 초기화
    _loop: loop
		set _cnt = _cnt + 1;							#반복문 돌면서 변수 + 1, 과목번호, 문제번호, 득점자수, 득점률  테이블에 넣기
			insert into reportQuestion values (_cnt, "a01", (select sum(a01) from Scoring where subjectID = _cnt), (select (sum(a01)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a02", (select sum(a02) from Scoring where subjectID = _cnt), (select (sum(a02)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a03", (select sum(a03) from Scoring where subjectID = _cnt), (select (sum(a03)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a04", (select sum(a04) from Scoring where subjectID = _cnt), (select (sum(a04)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a05", (select sum(a05) from Scoring where subjectID = _cnt), (select (sum(a05)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a06", (select sum(a06) from Scoring where subjectID = _cnt), (select (sum(a06)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a07", (select sum(a07) from Scoring where subjectID = _cnt), (select (sum(a07)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a08", (select sum(a08) from Scoring where subjectID = _cnt), (select (sum(a08)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a09", (select sum(a09) from Scoring where subjectID = _cnt), (select (sum(a09)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a10", (select sum(a10) from Scoring where subjectID = _cnt), (select (sum(a10)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a11", (select sum(a11) from Scoring where subjectID = _cnt), (select (sum(a11)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a12", (select sum(a12) from Scoring where subjectID = _cnt), (select (sum(a12)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a13", (select sum(a13) from Scoring where subjectID = _cnt), (select (sum(a13)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a14", (select sum(a14) from Scoring where subjectID = _cnt), (select (sum(a14)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a15", (select sum(a15) from Scoring where subjectID = _cnt), (select (sum(a15)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a16", (select sum(a16) from Scoring where subjectID = _cnt), (select (sum(a16)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a17", (select sum(a17) from Scoring where subjectID = _cnt), (select (sum(a17)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a18", (select sum(a18) from Scoring where subjectID = _cnt), (select (sum(a18)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a19", (select sum(a19) from Scoring where subjectID = _cnt), (select (sum(a19)/1000)*100 from Scoring where subjectID = _cnt));
            insert into reportQuestion values (_cnt, "a20", (select sum(a20) from Scoring where subjectID = _cnt), (select (sum(a20)/1000)*100 from Scoring where subjectID = _cnt));
		if _cnt = 3 then
			leave _loop; 								#_cnt변수가 3이되면 반복문 탈출
		end if;
	end loop _loop;
    
    select * from reportQuestion;						#테이블 조회
end $$
delimiter ;

call report2();											#프로시저 호출

 #과목별  득점자수가 적은 순으로 조회
select * from reportQuestion where subjectID = 1 order by count;
select * from reportQuestion where subjectID = 2 order by count;
select * from reportQuestion where subjectID = 3 order by count;