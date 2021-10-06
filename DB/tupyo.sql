create table tupyo(name varchar(20), age int); #테이블 생성

insert into tupyo values("나연", rand()*8 + 1); #인당 데이터 삽입 쿼리문 입력 
insert into tupyo values("정연", rand()*8 + 1); # random 범위가 0<= r < 1 이므로 1~9까지 얻기 위해 8까지 구한 후 + 1 해주기
insert into tupyo values("사나", rand()*8 + 1);
insert into tupyo values("모모", rand()*8 + 1);
insert into tupyo values("쯔위", rand()*8 + 1);
insert into tupyo values("다현", rand()*8 + 1);
insert into tupyo values("채영", rand()*8 + 1);
 
select count(*) from tupyo; #100개 확인을 위한 카운트 함수
select * from tupyo;


select age*10 as 연령대 , count(*) as 득표수, (count(*)/(select count(*) from tupyo)) * 100 as 득표율 
from tupyo group by age order by 득표수; #group by로 묶인 카운트 전체 카운트로 나눠주고 100 곱하여 득표율 구하기

select name as 이름 , count(*) as 득표수, (count(*)/(select count(*) from tupyo)) * 100 as 득표율 
from tupyo group by name order by 득표수 desc; #group by로 묶인 카운트 전체 카운트로 나눠주고 100 곱하여 득표율 구하기
 
 #나연이 받은 표 개수의 합에서의 득표율을 알아내기위해 where로 조건문 설정
select count(*) from tupyo where name = '나연';
select age*10 as 연령대 , count(*) as 득표수, (count(*)/(select count(*) from tupyo where name = '나연')) * 100 as 득표율
from tupyo where name = '나연' group by age order by 득표수 desc; #group by로 묶인 카운트 나연의 카운트로 나눠주고 100 곱하여 득표율 구하기