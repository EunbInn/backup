delete from Answer where subjectID > 0; 			#insert 전 데이터 지우기
drop procedure if exists inputAnswer;				#프로시져 지우기고 생성
delimiter $$
create procedure inputAnswer()
begin
declare cnt integer;								#반복문에서 쓰일 카운트 변수 선언
set cnt = 0;										#변수 초기화
   _loop: loop
      set cnt = cnt + 1;							#반복문 내에서 변수 + 1, 테이블에 랜덤숫자(답) insert
      insert into Answer values 
         (cnt, (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), 
			  (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1),
			  (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), 
			  (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1));
      if cnt = 3 then
         leave _loop;								#카운트 변수가 3이되면 루프 탈출
      end if;
   end loop _loop;									
end $$
delimiter ;

call inputAnswer();									#프로시져 호출
select * from Answer;								#결과물 확인

delete from Testing where stu_id > 0;				#insert 전 데이터 지우기
drop procedure if exists input_test;				#프로시져 지우기고 생성
delimiter $$
create procedure input_test(_last integer)
begin
declare _name varchar(20);							#이름 변수 선언
declare _id int;									#학번 변수 선언
declare _cnt int;									#루프문에서 쓰일 카운트 변수 선언
declare _innerCnt int;								#이중루프문에 쓰일 변수 선언
set _cnt = 0;										#변수 초기화
   _loop: loop
      set _innerCnt = 0;							#이중루프문에 쓰일 변수 초기화
        set _cnt = _cnt + 1;						#카운트 변수 루프 돌면서 + 1
      _loop2: loop
         set _innerCnt = _innerCnt + 1;				#이중 루프에서 돌면서 변수에 +1
            set _id = 20210000 + _innerCnt;			#학번 20210000 + innerCnt변수, 이름은 숫자문자열로 바꿔서 concat오로 합치기
            set _name = concat("김은비", cast(_innerCnt as char(4)));
			
            #값 집어넣기
            insert into Testing values(_cnt, _name, _id,
										(rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), 
										(rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1),
										(rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), 
										(rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1), (rand()*4+1));
                                        
            if _innerCnt = _last then
				leave _loop2; 						#_innerCnt변수가 인자로 받아온 integer값과 같으면 이중루프문 탈출
			end if;
		end loop _loop2;
      if _cnt = 3 then
         leave _loop; 								#_cnt변수가 3과 같으면 루프문 완전 탈출
      end if;
   end loop _loop;
end $$
delimiter ;

call input_test(1000); 								#프로시저 호출
select * from Testing limit 1000, 1000;			 	#1000번째 데이터부터 1000개 출력
select count(*) from Testing; 						#insert된 데이터 개수 확인

    