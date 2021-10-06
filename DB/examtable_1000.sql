use kopoctc;
drop table if exists examtable3; #테이블 존재 시 삭제 후 생성: 성적테이블
create table examtable3(
	num int not null primary key,
	name varchar(20),
    kor int, eng int, mat int);
desc examtable3;

drop procedure if exists insert_examtable2; #프로시져 존재시 지우고 다시 생성 인자 : integer type
delimiter $$
create procedure insert_examtable2(_limit integer)
begin
declare _name varchar(20); #문자열 변수 선언
declare _num integer; #인티저타입 변수 선언
declare _cnt integer; #루프문 카운트해줄 변수 선언
set _cnt = 0; # 루프 전 초기화
delete from examtable3 where _num > 0; # 데이터가 있으면 전체 삭제 (safe모드 때문에 where문 입력)
	_loop: loop
		set _cnt = _cnt + 1;
		
		set _name = concat("김은비",  cast(_cnt as char(4))); #이름과 번호 변수에 저장
		set _num = _cnt;
		
		insert into examtable3 values (_num, _name, rand()*100, rand()*100, rand()*100); #테이블에 데이터 삽입
		
		if _cnt = _limit then
			leave _loop;
		end if;
	end loop _loop;
end $$
delimiter ;
call insert_examtable2(1000); #프로시저 호출
select count(*) from examtable3;#생성된 자료 개수 조회
select * from examtable3; #전체자료 조회

drop view if exists examview; # 이름, 학번, 국영수 개별점수, 총점, 평균, 등수 보여주는 뷰 생성
create view examview(num ,name, kor, eng, mat, tot, ave, ran)
as select *, b.kor+b.eng+b.mat,
	(b.kor+b.eng+b.mat)/3,
    (select count(*)+1 from examtable3 as a
		where (a.kor+a.eng+a.mat) > (b.kor+b.eng+b.mat))
        from examtable3 as b;

drop function if exists f_lastpage; # 마지막페이지 계산하는 함수
delimiter $$
create function f_lastpage(_viewnum integer) returns integer
begin
declare _lastpage integer;
	if (select count(*) from examtable3)%_viewnum = 0 then 
		set _lastpage = (select count(*) from examtable3)/_viewnum;
	elseif (select count(*) from examtable3)%_viewnum > 0 then
		set _lastpage = (select count(*) from examtable3)/_viewnum + 1; 
	end if; #전체 데이터 행을 보여줄 행수로 나눈 나머지가 0이면 몫으로, 나머지가 0보다 크면 몫 + 1로 마지막페이지 변수 저장 
	return _lastpage;
end $$

drop procedure if exists print_report; #프로시져 존재시 지우고 다시 생성 인자 : integer type
delimiter $$
create procedure print_report(_page integer, _viewnum integer)
begin
declare _start integer; #시작점 변수 선언
declare _lastpage integer; #마지막페이지 계산하여 저장할 변수 선언
	set _lastpage = f_lastpage(_viewnum);
	if _page < 1 then
		set _page = 1;
		elseif _page > _lastpage then
			set _page = _lastpage;
	end if; #들어온 페이지 값이 1보다 작으면 1로, 마지막페이지보다 크면 마지막페이지로 페이지변수 셋팅

	set _start = (_page - 1) * _viewnum; #스타트 지점은 page변수 -1 * 보여주고 싶은 행수
	select * from examview limit _start, _viewnum; #변수에 저장된 값으로 limit하여 출력
end $$
delimiter ;

drop procedure if exists print_report_nowsum; #프로시져 존재시 지우고 다시 생성 인자 : integer type
delimiter $$
create procedure print_report_nowsum(_page integer, _viewnum integer)
begin
declare _start integer; #시작점 변수 선언
declare _lastpage integer; #마지막페이지 계산하여 저장할 변수 선언
	set _lastpage = f_lastpage(_viewnum);
	if _page < 1 then
		set _page = 1;
		elseif _page > _lastpage then
			set _page = _lastpage;
	end if; #들어온 페이지 값이 1보다 작으면 1로, 마지막페이지보다 크면 마지막페이지로 페이지변수 셋팅

	set _start = (_page - 1) * _viewnum; #스타트 지점은 page변수 -1 * 보여주고 싶은 행수
	select sum(kor),sum(eng),sum(mat),sum(tot),sum(ave),
		avg(kor),avg(eng),avg(mat),avg(tot),avg(ave)
		from (select * from examview limit _start, _viewnum) as a; #변수에 저장된 값으로 limit하여 출력
end $$
delimiter ;

drop procedure if exists print_report_totsum; #프로시져 존재시 지우고 다시 생성 인자 : integer type
delimiter $$
create procedure print_report_totsum(_page integer, _viewnum integer)
begin
declare _start integer; #시작점 변수 선언
declare _total integer; #누적개수 변수 선언
declare _lastpage integer; #마지막페이지 계산하여 저장할 변수 선언
	set _lastpage = f_lastpage(_viewnum);
	if _page < 1 then
		set _page = 1;
		elseif _page > _lastpage then
			set _page = _lastpage;
	end if; #들어온 페이지 값이 1보다 작으면 1로, 마지막페이지보다 크면 마지막페이지로 페이지변수 셋팅

	set _start = 0; #스타트 지점은 0
	set _total = _page*_viewnum; #누적개수 = 페이지 * 페이지별 보여주는 행 수
	select sum(kor),sum(eng),sum(mat),sum(tot),sum(ave), 
		avg(kor),avg(eng),avg(mat),avg(tot),avg(ave)
		from (select * from examview limit _start, _total) as a; #변수에 저장된 값으로 limit하여 출력
end $$
delimiter ;

call print_report(5, 25);
call print_report_nowsum(5, 25);
call print_report_totsum(5, 25);
