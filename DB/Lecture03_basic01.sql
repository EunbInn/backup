use kopoctc;
DROP PROCEDURE IF EXISTS insert_examtable; # 같은 이름의 프로시져가 존재한다면 삭제
DELIMITER $$ 
CREATE PROCEDURE insert_examtable(_last integer) 
BEGIN #프로시져 시작
DECLARE _name varchar(20); #변수 정의
DECLARE _id integer;
DECLARE _cnt integer;
set _cnt = 0; #값 초기화
delete from examtable where id > 0;
	_loop: LOOP
        SET _cnt = _cnt + 1;
        SET _name = concat("김은", cast(_cnt as char(4)));
        SET _id = 209900+_cnt;
        
        INSERT INTO examtable VALUE (_name, _id, rand()*100, rand()*100, rand()*100);
        
		IF _cnt = _last THEN
			LEAVE _loop;
		END IF;
	END LOOP _loop;
END $$

DELIMITER ; #구분자 되돌리기

call insert_examtable(100);#프로시져 호출
select * from examtable; #전체조회
select count(*) from examtable;
select *, kor+eng+mat as sum, (kor+eng+mat)/3 as ave, 
	(select count(*)+1 from examtable as a
		where (a.kor+a.eng+a.mat) > (b.kor+b.eng+b.mat)) as ran from examtable as b;


DROP FUNCTION IF EXISTS f_get_rank; #함수가 이미 있다면 삭제
DELIMITER $$ 

CREATE FUNCTION f_get_rank(_id integer) RETURNS integer 
BEGIN #함수시작
	DECLARE _rank integer; #변수 선언
    SELECT (select count(*)+1 from examtable as a
		where (a.kor+a.eng+a.mat) > (b.kor+b.eng+b.mat)) INTO _rank FROM examtable as b WHERE id = _id; #셀렉트 문으로 가져온 값을 변수에 저장

RETURN _rank; #sum값 리턴
END $$
DELIMITER ; 

select *, kor+eng+mat as sum, (kor+eng+mat)/3 as ave, 
	f_get_rank(id) as ran from examtable order by ran;