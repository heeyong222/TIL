-- 실행 순서 
select employee_id as empno, first_name, salary
from   employees;
-- where  empno=100;      --error 발생

select job_id as job, sum(salary) as salary
from   employees
group by job;

select employee_id as empno, first_name, salary
from   employees
order by empno desc;

-- like
select employee_id as empno, first_name, salary
from   employees
where  first_name like 'L__';

select employee_id as empno, first_name, salary
from   employees
where  first_name like 'L%';

select employee_id as empno, first_name, salary
from   employees
where  first_name like 'L\%';    -- L%

/*
 case ~ when ~ then    : when에 지정된 조건이 참이면 then이 수행됨. 
 형식]
   case  
       when  조건  then 수행할 값, 연산식
       when ...
       else  주어진 조건이 모두 아닌 경우 수행될 값, 연산식
   end    
*/
/* 분류 번호가 10인 경우  음식
   20인 경우 전자제품
   30인 경우 책
   40인 경우 가구  */
select gno, brand, price, cno,
	   case 
         when cno=10 then '음식'
         when cno=20 then '전자제품'
         when cno=30 then '책'
         when cno=40 then '가구'
         else '미분류'
	   end  as cname
from   goods;       

/* 
   상품번호, 상품명, 인상전 가격, 인상후 가격을 조회 하시오.	
   가격 인상은 다음과 같다. 
   가격이 10000원 미만이면 15%을 가격을 인상하고 10000원 이상은 10% 가격을 인상하시오
   인상된 가격을 기준으로 오름 차순으로 정렬하시오
*/

select gno, brand, price as "인상전 가격",
	   case when price <10000 then price *1.15
            else price * 1.1
	   end as IncPrice
from   goods
order by   IncPrice;    
	  

-- if      -- mysql 전용 case ~when then 간략 함수 ,    oracle 인경우 decode
-- if( 조건, true일 경우, false일 경우)
select gno, brand, price as "인상전 가격",
	   if(price <10000, price *1.15, price * 1.1) as IncPrice
from   goods
order by   IncPrice;          

select gno, brand, price, cno,
	   if( cno=10 ,'음식'
		   , if(cno=20 ,'전자제품'
           , if(cno=30 ,'책'
           , if(cno=40 ,'가구', '미분류'))))  as cname
from   goods;  

/*
decode(조건, 참일때 , 거짓일때)
decode(조건, 참일때 
      ,조건, 참일때
      ,조건, 참일때
      ,조건, 참일때,...
      ,거짓일때 ) */
    
-- commission_pct 이 null인 경우  0으로 표시 null이 아닌경우 해당 commission_pct으로 조회 
select employee_id,first_name,salary,commission_pct,
	   if(commission_pct is null ,0, commission_pct) as commpct
from   employees;       

      
-- ifnull(조건, 대체할 값) : 조건이 null이면 대체값이, null이 아니는 원래 값이 조회   oracle : nvl(컬럼며, 대체값)
select employee_id,first_name,salary,commission_pct,
	   ifnull(commission_pct,0) as commpct
from   employees; 


-- replace
select replace('hello world hell heam','he', 'go') from dual;

-- dual 테이블 : dumy 테이블 
-- 연산이나 함수를 수행할 경우 select문으로 수행해야 한다. 
-- 그런데 select문은 반드시 from을 동반 
select replace('hello world hell heam','he', 'go') from employees;

/*
  DDL문 (Data Definition Language)
  - Database에서 사용하는 다양한 객체를 생성, 삭제, 변경하는 문
  - 수행하면 DB에 바로 반영됨
  - 종류 : table, index,  view, database, procedure
  - 생성    : create 객체  객체명;
    ex) create sequence board_no;
  - 삭제    : drop  객체  객체명;
    ex) drop sequence board_no;
*/

/* 테이블 
   - 데이타를 관리할 최소 단위 
   - 생성 
	 create table 테이블명(
        컬럼명   데이타타입   [[CONSTRAINT 제약조건이름] 컬럼레벨 제약조건]
        , ...
        ,[[CONSTRAINT 제약조건이름] 테이블레벨 제약조건] 
     );
*/


-- 날짜 기본값 설정  5.6.5 미만은 now()
-- 날짜 기본값 설정  5.6.5 이상은 current_timestamp
/* 주문 테이블 
 ono 		: 주문번호			primairy key
 odate 		: 주문일
 id			: 주문한 고객 아이디	foreign key
 gno		: 상품 번호 		foreign key
 quantity	: 주문한 수량 
 address	: 배송지
*/
create table orders (
	ono			int			primary key  auto_increment,
    odate		datetime	default		current_timestamp,
    id			varchar(30)	not null,
    gno			int			not null,
    quantity	int					,
    address	    varchar(100),
    constraint  foreign key orders_id_fk(id) references member(id),
    constraint  foreign key orders_gno_fk(gno) references goods(gno)
);











