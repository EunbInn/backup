use kopoctc;
DROP PROCEDURE IF EXISTS get_sum; # 같은 이름의 프로시져가 존재한다면 삭제
DELIMITER $$ #문장구분을 쉽게 하기 위해 구분자 변경
CREATE PROCEDURE get_sum ( # 프로시져 생성 
	IN _id integer, #파라미터  IN으로 정의
    OUT _name varchar(20), #테이블에서 가져올 값 OUT으로 정의
    OUT _sum integer
)

BEGIN #프로시져 시작
	DECLARE _kor integer; #변수 정의
    DECLARE _eng integer;
    DECLARE _mat integer;
    set _kor = 0; #정의한 값 초기화
    set _eng = 0;
    set _mat = 0;
    
    select name, kor, eng, mat #id값으로 셀렉한 내용을 변수에 저장
		into _name, _kor, _eng, _mat from examtable where id = _id;
        
	set _sum = _kor + _eng + _mat;
END $$
DELIMITER ; #구분자 되돌리기

call get_sum(209901, @name, @sum); #프로시저 호출하여 저장
select @name, @sum; #결과값 출력