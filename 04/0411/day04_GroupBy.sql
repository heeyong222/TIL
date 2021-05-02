/*
   데이타를 특정 컬럼의 데이타를 기준으로 group을 나눠서 group함수적용
   group by 컬럼명    지정한 컬럼의 데이타를 분류해서 group을 생성 

   *** Mysql은 ONLY_FULL_GROUP_BY 설정이 기본으로 안되어 있어서 
   select employee_id, sum(salary)  from    employees;  쿼리에서 오류가 발생하지 않는다 

   set @@session.sql_mode='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';
*/

select cno, count(*), avg(price)
from   goods
group by cno;

-- 부서별 급여 평균과, 최소 급여, 최대 급여를 조회 


-- 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회 



/* havaing  
   - group의 값으로 조건 
   - 형식]  group by  컬럼, ...
           havaing   조건 
           
   where => 행 하나 하나에 대한 조건 처리         
*/

-- 업무별 급여 평균이 2500이상이 업무 조회 


-- 카테고리별 가격 평균을 조회 단, 가격 평균이 500000이상인 카테고리는 제외하고 조회한다. 


-- 급여가 1500이상인 사원들의 부서별 급여 평균을 조회
-- 단 급여 평균이 2000이상인 부서만 조회 




/*rollup :group별 통계에  전체 통계를 추가로 조회 
  형식] group by 컬럼명 with rollup;
 */
-- 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회


/**oralce 버전
select ifnull(job,'total'), count(*), round(avg(sal),2), min(sal), max(sal)
from   emp
group by rollup(job);
*/

/*grouping()
  rollup에 의해 조회된 데이타는 1 그렇지 않은 데이타는 0이 조회된다. 
*/


-- cno가 null인 경우 미분류로 표시, 그렇지 않으면 카테고리 번호로 표시 
-- rollup에 의해 null인 경우 total 





-- 부서별, 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회 


insert into emp (empno, job, sal) values(1111,'ANALYST', 3000);








