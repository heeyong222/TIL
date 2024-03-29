/*
 Join 
 - 두개 이상의 테이블을 연결해서 질의하는 것
 - 종류 
    1. 데이타 추출되는 것에 따라 
      Inner Join : 
        - 조인을 위해 사용하는 비교 조건에 맞는 데이타만 조회
        - 조인 조건에 맞지 않은 데이타는 조회 되지 않는다. 
        - join할 때  outer join으로 표시 하지 않으면 기본적으로 
          Inner join으로 조회된다. 
      Outer Join 
        - 조인을 위해 사용하는 비교 조건에 맞지 않는 데이타도 조회된다. 
		- 종류 
          left outer join  : 비교 조건에 맞지 않은 왼쪽 테이블의 데이타도 조회됨
          right outer join : 비교 조건에 맞지 않은 오른쪽 테이블의 데이타도 조회됨
          full outer join  : 비교 조건에 맞지 않은 양쪽 테이블의 모든 데이타가 조회됨
    2. 비교 조건에 따라서 
	  Equi join 
        - 비교하는 두 컬럼의 데이타가 정확하게 일치할 경우 
        - join 조건으로 = 비교 연산자를 이용할 경우 
      Non Equi join 
        - 비교하는 두 컬럼의 데이타가 정확하게 일치하지 경우 
        - join 조건으로  >, < , >= , <=, != 등
    3. 비교 테이블에 따라서 
	  self join 
        - join할 테이블이 다른 테이블이 아닌 self(한개의 테이블로 join)
        - 테이블을 구별하기 위해 반드시 alias를 사용해야 한다. 
        
    4. 카티시안 곱(cross join)
      - 조인 조건을 생략했을 때 두 테이블의 모든 row를 연결한 결과가 조회된다. 
	  - N * M의 수만++++
	5. Netural join
      - 조인 테이블에서 동일한 컬럼명을 기준으로 조인
*/


-- 상품번호, 상품이름, 가격, 분류번호, 분류이름 조회
-- 카티시안 곱 
select gno, brand, price, goods.cno, name
from   goods, category;





/*
 inner join 
 -DB 벤더 전용
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias], 테이블명 [alias] , 
  [where  조인 조건 ]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]
  
 -ANSI query 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias]
  join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)
  ,...
  [where  조건]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]	
 
  using 
   - 조인을 위한 비교 컬럼명이 동일 할 때 사용 
   - alias 없이 사용해야 한다. => mysql은 error 발생 안함(다른 DB에서는 alias를 사용할 경우 error발생)
   - 비교 조건은 기본적으로 = 이 적용된다. 
  on
   - 조인을 위한 비교 컬럼명이 다르거나 비교 조건이 = 이 아닐때 사용한다. 
   - 조인을 위한 비교 컬럼이 같을 경우 alias를 사용해서 구분한다. 
*/

-- 상품번호, 상품이름, 가격, 분류번호, 분류이름 조회
-- inner join  벤더 전용
select gno, brand, price, goods.cno, name
from   goods, category
where  goods.cno= category.cno;

-- 테이블에 alias를 적용
select gno, brand, price, g.cno, name
from   goods g, category c
where  g.cno= c.cno;

-- ansi query1
select gno, brand, price, cno, name
from   goods
join   category
using  (cno);

-- ansi query2
select gno, brand, price, g.cno, name
from   goods g
join   category c
on     g.cno=c.cno;

-- 주문일, 주문 번호, 주문한 상품 번호, 상품명, 주문자 id, 상품가격, 주문 수량, 주문 금액을 조회하시오.
-- vender 전용
select odate, ono, o.gno, brand, id, price, 
		quantity, quantity*price as totalPrice
from   orders o, goods g
where  o.gno = g.gno;        

-- ansi (using)
select odate, ono, gno, brand, id, price, 
		quantity, quantity*price as totalPrice
from   orders 
join   goods 
using  (gno); 


-- 이번달에 주문한 상품에 대한 정보 조회 
-- 주문일, 주문 번호, 주문한 상품 번호, 상품명, 주문자 id, 상품가격, 주문 수량, 주문 금액을 조회하시오.
-- vender 전용
select odate, ono, o.gno, brand, id, price, 
		quantity, quantity*price as totalPrice
from   orders o, goods g
where  o.gno = g.gno
       and date_format(now(), '%y%m') = date_format(odate,'%y%m');  

-- ansi (using)
select odate, ono, gno, brand, id, price, 
		quantity, quantity*price as totalPrice
from   orders 
join   goods 
using  (gno)
where 	date_format(now(), '%y%m') = date_format(odate,'%y%m');  


select * from orders;

-- 사원번호, 이름, 업무, 급여, 급여등급을 조회
-- vender
select empno, ename, job, sal, grade
from   emp, salgrade
-- where  sal >= losal and sal <=hisal;
where  sal between losal and hisal ;

-- ansi
select empno, ename, job, sal, grade
from   emp
join   salgrade
on	  sal between losal and hisal ;

select * from emp;

-- 사원번호, 이름, 업무, 급여, 급여등급, 부서번호, 부서명을 조회
-- vender
select empno, ename, job, sal, grade, e.deptno, dname
from   emp e, salgrade, dept d
where  sal between losal and hisal 
	   and e.deptno = d.deptno;

-- ansi
select empno, ename, job, sal, grade, deptno, dname
from   emp 
join   salgrade
on     sal between losal and hisal 
join   dept
using  (deptno);

-- 주문번호, 주문일자, 상품명, 주문자 id, 주문자명, 가격, 수량, 주문가격을 조회
-- vender 
select 	ono, odate, brand, o.id, name, price, 
       quantity, price* quantity as total
from    orders o, goods g, member m
where   o.gno = g.gno and o.id = m.id;

-- ansi
select 	ono, odate, brand, id, name, price, 
       quantity, price* quantity as total
from    orders
join    goods 
using   (gno)
join    member 
using   (id);


-- 상품별 주문 수량을 조회하려 한다. 
-- 상품 번호(gno), 상품명(brand), 총 주문된 수량을 조회
-- vender 


/*
 outer join
 -left join 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias] 
  left [outer] join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)

 - right join 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias] 
  right [outer] join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)
*/
insert into emp (empno, ename, sal)
values(1000,'김싸피',10000);

-- inner join으로 deptno가 없는 사원은 조회되지 않음 
select empno, ename, sal, e.deptno as deptno, dname
from   emp e, dept d
where  e.deptno = d.deptno;

select empno, ename, sal,  deptno, dname
from   emp 
join   dept 
using  (deptno);

-- emp테이블을 기준으로 left join하면 deptno가 없는 사원도 조회됨. 
select empno, ename, sal,  deptno, dname
from   emp left join   dept 
using  (deptno);

select empno, ename, sal,  deptno, dname
from   dept  right join   emp
using  (deptno);


-- goods의 모든 상품에 대해 상품번호, 이름, 가격, 분류번호, 분류명을 조회
select gno, brand, price, cno, name
from   goods
left join category
using  (cno);


-- 사원번호, 이름, 급여, 급여 등급을 조회하시오
select empno, ename, sal, grade
from   emp
left join salgrade
on	   sal 	between losal and hisal;

-- 모든 상품에 대하여 상품별 주문 수량을 조회하려 한다. 
-- 상품 번호(gno), 상품명(brand), 총 주문된 수량을 조회


/*
self join 
 - 한개의 테이블로 join 
 - 테이블에 alias를 이용해서 구별한다. 
*/
-- 사원번호, 사원이름, 업무, 급여, 상사번호, 상사이름 조회 
select e.empno , e.ename, e.job, e.sal, e.mgr, m.ename
from   emp e
join   emp m
on     e.mgr = m.empno;


-- 모든 사원에 대한 사원번호, 사원이름, 업무, 급여, 상사번호, 상사이름 조회
-- (상사가 없는 사원도 조회)
select e.empno , e.ename, e.job, e.sal, e.mgr, m.ename
from   emp e
left join   emp m
on     e.mgr = m.empno;








