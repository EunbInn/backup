use kopoctc;
SET GLOBAL log_bin_trust_function_creators = 1; #함수 생성 전 생성자 신뢰 true로 변경
drop function if exists get_score; #fucntion 존재하면 드롭
delimiter $$
# 과목번호, 학생 이름, 학번을 인자로 받고 integer를 반환하는 함수 선언
create function get_score(_sub integer, _name varchar(20), _id integer) returns integer
begin
declare _a01, _a02, _a03, _a04, _a05, _a06, _a07, _a08, _a09, _a10,
   _a11, _a12, _a13, _a14, _a15, _a16, _a17, _a18, _a19, _a20 integer;	#문제 번호 변수 선언		
declare sum integer; #합계 변수 선언

#문제 번호가 같으면 count는 1 같지 않으면 0으로 표기 됨 해당 내용을 선언해둔 문제 변수에 저장
select count(*) into _a01 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a01 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a02 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a02 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a03 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a03 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a04 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a04 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a05 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a05 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a06 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a06 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a07 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a07 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a08 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a08 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a09 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a09 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a10 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a10 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a11 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a11 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a12 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a12 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a13 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a13 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a14 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a14 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a15 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a15 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a16 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a16 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a17 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a17 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a18 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a18 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a19 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a19 and a.stu_id = _id and a.subjectID = _sub;
select count(*) into _a20 from Testing as a where (select a01 from Answer where subjectID = _sub) = a.a20 and a.stu_id = _id and a.subjectID = _sub;

set sum = _a01+_a02+_a03+_a04+_a05+_a06+_a07+_a08+_a09+_a10+_a11+_a12+_a13+_a14+_a15+_a16+_a17+_a18+_a19+_a20; #합계 구하기
insert into Scoring values(_sub, _name, _id,
							_a01, _a02, _a03, _a04, _a05, _a06, _a07, _a08, _a09, _a10, 
							_a11, _a12, _a13, _a14, _a15, _a16, _a17, _a18, _a19, _a20, sum*5); #점수 테이블에 구한 값들 insert, 점수는 합계 * 5
return sum*5; #점수 반환

end $$
delimiter ;

delete from Scoring where stu_id>0;	#함수 호출 전 테이블 내용 정리
select get_score(subjectID, stu_name, stu_id) from Testing; #함수 호출
select * from Scoring;