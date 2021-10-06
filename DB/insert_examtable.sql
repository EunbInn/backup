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

call insert_examtable(1000);#프로시져 호출
select * from examtable; #전체조회
select count(*) from examtable;
select *, kor+eng+mat as sum, (kor+eng+mat)/3 as ave from examtable LIMIT 30, 59; #31번째값부터 59개 출력
