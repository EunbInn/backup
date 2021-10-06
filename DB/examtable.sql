use kopoctc;
drop table if exists examtable; #테이블이 있다면 지우고 다시 생성
create table examtable(
	name varchar(20),
	id int not null primary key, #id값을 p-key로 지정
	kor int, eng int, mat int);
desc examtable; #테이블 구성 조회

delete from examtable where id>0; #데이터 삭제

INSERT INTO examtable VALUES ("나연", 209901, rand()*100, rand()*100, rand()*100); #데이터 입력
INSERT INTO examtable VALUES ("정연", 209902, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("모모", 209903, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("사나", 209904, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("지효", 209905, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("미나", 209906, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("다현", 209907, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("채영", 209908, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("쯔위", 209909, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("민현", 209910, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("민현", 209911, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("나연", 209912, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("정연", 209913, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("모모", 209914, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("사나", 209915, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("지효", 209916, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("미나", 209917, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("다현", 209918, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("채영", 209919, rand()*100, rand()*100, rand()*100);
INSERT INTO examtable VALUES ("쯔위", 209920, rand()*100, rand()*100, rand()*100);
select * from examtable; #전체 출력
select count(*) from examtable; #전체 데이터 개수 출력

select * from examtable order by kor; #국어 성적순으로 오름차순 정렬
select * from examtable order by eng; #영어 성적순으로 오름차순 정렬
select * from examtable order by kor, eng; #국어 성적 우선, 동점자는 영어성적으로 정렬 처리
select * from examtable order by eng asc; #영어 성적순으로 오름차순 정렬 --> 디폴트
select * from examtable order by eng desc; #영어 성적순으로 내림차순 정렬

select * from examtable order by name desc; #이름 내림차순(역순) 정렬
select * from examtable order by mat desc; #수학 성적순으로 내림차순 정렬

#각 컬럼값을 더하고 개수만큼 나누어 총점과 평균값 계산
select *, kor+eng+mat, (kor+eng+mat)/3 from examtable; 
select *, kor+eng+mat, (kor+eng+mat)/3 from examtable order by kor+eng+mat desc; #총점의 역순
select *, kor+eng+mat as total, (kor+eng+mat)/3 as average from examtable order by total desc;
select name as 이름, id as 학번, kor as 국어, eng as 영어, mat as 수학,
	kor+eng+mat as 합계, (kor+eng+mat)/3 as 평균 from examtable order by 합계 desc;


select * from examtable group by name;

select name, count(name) from examtable group by name;
select * from examtable group by kor;
select kor, count(kor) from examtable group by kor;
select kor, count(kor) from examtable group by eng;
select kor, count(kor), eng, count(eng) from examtable group by kor,eng;

insert into examtable value("펭수", 209921, 100, 90, rand()*100); #펭수 데이터 인서트
insert into examtable value("펭수", 209922, 100, 90, rand()*100); 

select kor, count(kor),  eng, count(eng) from examtable group by kor, eng; #국어영어성적이 같은 경우 펭수때문에 동점자 있음
select name, count(name), kor, count(kor), eng, count(eng)from examtable group by name, kor, eng; #이름국어영어 동일자
select *, name, count(name), kor, count(kor), eng, count(eng) from examtable group by name, kor, eng; #에러

select eng, count(eng) from examtable group by eng having count(eng)>1; #동일한 영어 성적의 수가 1보다 많을 경우

