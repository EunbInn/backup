#error 1418 이 날 경우 함수 생성기가 꺼져있을 수 있으므로 변수확인 후 1(ON)으로 변경
show global variables like 'log_bin_trust_function_creators'; 
SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS f_get_sum; #함수가 이미 있다면 삭제
DELIMITER $$ #함수문을 더 쉽게 구분하기 위해 구분문자 정의

CREATE FUNCTION f_get_sum(_id integer) RETURNS integer #파라미터와 리턴타입 정의하여 함수선언
BEGIN #함수시작
	DECLARE _sum integer; #변수 선언
    SELECT kor+eng+mat INTO _sum FROM examtable WHERE id = _id; #셀렉트 문으로 가져온 값을 변수에 저장

RETURN _sum; #sum값 리턴
END $$
DELIMITER ; #구분문자 다시 세미콜론으로 되돌림

select *, f_get_sum(id) from examtable; 함수호출