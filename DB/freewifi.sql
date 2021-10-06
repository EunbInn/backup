use kopoctc;

drop function if exists f_lastP; # 마지막페이지 계산하는 함수
delimiter $$
create function f_lastP(_viewnum integer) returns integer
begin
declare _lastpage integer;
	if (select count(*) from freewifi2)%_viewnum = 0 then 
		set _lastpage = (select count(*) from freewifi2)/_viewnum;
	elseif (select count(*) from freewifi2)%_viewnum > 0 then
		set _lastpage = (select count(*) from freewifi2)/_viewnum + 1; 
	end if; #전체 데이터 행을 보여줄 행수로 나눈 나머지가 0이면 몫으로, 나머지가 0보다 크면 몫 + 1로 마지막페이지 변수 저장 
	return _lastpage;
end $$
delimiter ;

drop procedure if exists print_reportW; #프로시져 존재시 지우고 다시 생성 인자 : integer type
delimiter $$
create procedure print_reportW(_page integer, _viewnum integer)
begin
declare _start integer; #시작점 변수 선언
declare _lastpage integer; #마지막페이지 계산하여 저장할 변수 선언
declare mylat double;
declare mylng double;
	set mylat = 37.651046682507; #우리집 위도
	set mylng = 127.32063430997; #우리집 경도
	set _lastpage = f_lastpage(_viewnum);
	if _page < 1 then
		set _page = 1;
		elseif _page > _lastpage then
			set _page = _lastpage;
	end if; #들어온 페이지 값이 1보다 작으면 1로, 마지막페이지보다 크면 마지막페이지로 페이지변수 셋팅

	set _start = (_page - 1) * _viewnum; #스타트 지점은 page변수 -1 * 보여주고 싶은 행수
	select (@rownum := @rownum + 1) as 번호,
		t.place_addr_land as 주소, 
		t.latitude as 위도,
        t.longitude as 경도,
        (6371*acos(cos(radians(mylat))*cos(radians(t.latitude))*cos(radians(t.longitude)-radians(mylng))
        +sin(radians(mylat))*sin(radians(t.latitude)))) as 거리
		from freewifi2 as t, (SELECT @ROWNUM := _start) R limit _start, _viewnum; #변수에 저장된 값으로 limit하여 출력
end $$
delimiter ;

call print_reportW(5, 25);
