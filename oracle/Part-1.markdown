## DB Course

+ [CS145 Introduction to Databases](http://web.stanford.edu/class/cs145/)

+ [Database Stanford Dbclass](https://www.youtube.com/playlist?list=PLLH73N9cB21WYr92CFMaE1ygwqLiBWz4I)

+ [18 Essential SQL Interview Questions (Toptal)](http://www.toptal.com/sql/interview-questions)

+ [SQL Queries Interview Questions - Oracle Part 1](http://www.folkstalk.com/2011/12/sql-queries-interview-questions-oracle.html)

+ [Left Outer Join using + sign in Oracle 11g](http://stackoverflow.com/questions/6559261/left-outer-join-using-sign-in-oracle-11g)

+ [How to perform FULL OUTER JOIN in ORACLE using '+' operator?](http://stackoverflow.com/questions/10500020/how-to-perform-full-outer-join-in-oracle-using-operator)

+ [Isolation (database systems)](https://en.wikipedia.org/wiki/Isolation_(database_systems))

+ [On Transaction Isolation Levels](http://www.oracle.com/technetwork/issue-archive/2010/10-jan/o65asktom-082389.html)

#### Oracle

+ [Oracle - Analytic Function](Oracle---Analytic-Function)

+ [Oracle - Optimization](Oracle---Optimization)

+ [datetime function pdf](http://www-is.offis.uni-oldenburg.de/sqlkurs/sql/pdf/Les16.pdf)

+ [PL-SQL](PL-SQL)

+ [sqlplus](sqlplus)

## Hierarchical Query

```sql
CREATE TABLE corporate_slaves(
  slave_id INTEGER PRIMARY KEY,
  supervisor_id REFERENCES corporate_slaves,
  name varchar(100)
);
```
```sql
insert into corporate_slaves values (1, NULL, 'Big Boss Man');
insert into corporate_slaves values (2, 1, 'VP Marketing');
insert into corporate_slaves values (3, 1, 'VP Sales');
insert into corporate_slaves values (4, 3, 'Joe Sales Guy');
insert into corporate_slaves values (5, 4, 'Bill Sales Assistant');
insert into corporate_slaves values (6, 1, 'VP Engineering');
insert into corporate_slaves values (7, 6, 'Jane Nerd');
insert into corporate_slaves values (8, 6, 'Bob Nerd');
```
```sql
SELECT *
FROM
  (SELECT t1.supervisor_id supervisor_id,
    t1.slave_id slave_id,
    t2.supervisor_id supervisor_id1,
    t2.slave_id slave_id1
  FROM
    (SELECT DISTINCT t1.supervisor_id,
      t1.slave_id
    FROM corporate_slaves t1,
      corporate_slaves t2
    WHERE t1.supervisor_id= t2.supervisor_id
    AND t1.supervisor_id  = 1
    ) t1,
    corporate_slaves t2
  WHERE t1.slave_id=t2.supervisor_id(+)
  ) t11 ,
  corporate_slaves t22
WHERE t11.slave_id1=t22.supervisor_id (+);
```

``` sql
drop table test_connect_by;

create table test_connect_by (
  parent_1     number,
  child_1      number
);

insert into test_connect_by values (1,2);
insert into test_connect_by values ( 2,3);
insert into test_connect_by values ( 3,4);
insert into test_connect_by values ( 2,5);


SELECT  level,parent_1,connect_by_root parent_1,child_1 from test_connect_by 
 CONNECT BY PRIOR  child_1= parent_1 ;
```

##### Reference

+ http://www.cs.duke.edu/courses/fall04/cps116/lectures/11-recursion.pdf

+ http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.367.6352&rep=rep1&type=pdf

+ http://philip.greenspun.com/sql/


## [Lecture-06-04: Subquery in where clause ](https://www.youtube.com/watch?v=IJPXosPGLTU&index=13&list=PL6hGtHedy2Z4EkgY76QOcueU8lAC4o6c3)

```sql
SELECT sid,
       sname
FROM student
WHERE sid IN
    (SELECT sid
     FROM Apply
     WHERE major='CS');
```
+ Same query can be written using join condition :-

```sql
SELECT student.sid,
       sname
FROM student,
     apply
WHERE student.sid = apply.sid
  AND major = 'CS'
```
+ It will not return distinct record, so will have to add `distinct` operator

+ Duplicate may impact the result set when we use aggregate function like `avg`

#### corelate subquery in where clause

```sql
SELECT cName,
       STATE
FROM Colleage cq
WHERE EXISTS
    (SELECT *
     FROM college c2
     WHERE c2.STATE = c1.STATE
       AND c1.cname <> c2.cname)
```
+ maximum enrollment without using `max` function

```sql
SELECT sNmae
FROM college c1
WHERE NOT EXISTS
    (SELECT *
     FROM college c2
     WHERE c2.enrollmnet > c1.enrollmnet);
```
+ using join

```sql
SELECT sq.sNmae,
       s1.gpa
FROM student s1,
     student s2
WHERE s1.gpa > s2.gpa;
```
+ It does not work as expected, because it is checking for some (`any` operator) not `all` operator

```sql
SELECT sname,
       gpa
FROM student
WHERE gpa >= ALL
    (SELECT gpa
     FROM student)
```
+ `any/all` operator can be written `exist` or `not exist` operator. Tricky operator, so analyse query before using it.


```sql
with test1 as (select * from app_user where id<3),
test2 as (select * from app_user where id > 1)
select * from test1 union all select * from test2;
```

#### NULLS in SQL

Whenever we don’t have a value,	we can put a NULL

+ Can mean many	things:
	+ Value	does not exists
	+ Value	exists but is unknown
	+ Value	not applicable
	+ Etc.
			
+ The schema specifies for each	attribute if can be null (nullable attribute) or not

+ How does SQL cope with tables	that have NULLs?

#### Null Values

+ For numerical operations, NULL -> NULL:
    + If x = NULL then 4*(3-x)/7 is still NULL

+ For boolean operations, in SQL there are three values:
    + FALSE =  0
    + UNKNOWN =  0.5
    + TRUE =  1

+ If x= NULL then x=“Joe” is UNKNOWN



```sql
drop table test_123;
create table test_123 (
  id_nbr number,
  name_txt varchar2(100),
  id_group number,
  amount number,
	job_id number
);

insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(1,'E1',1,10,1);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(2,'E2',2,10,2);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(3,'E3',3,10,3);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(4,'E4',4,10,4);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(5,'E5',5,10,5);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(6,'E6',1,10,2);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(7,'E7',2,10,2);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(8,'E8',3,10,3);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(9,'E9',4,10,4);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(10,'E10',5,10,5);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(11,'E11',1,10,3);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(12,'E12',2,10,2);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(13,'E13',3,10,3);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(14,'E14',4,10,4);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(15,'E15',5,10,5);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(16,'E16',1,10,1);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(17,'E17',2,10,2);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(18,'E18',4,10,4);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(19,'E19',3,10,3);
insert into test_123(id_nbr,name_txt,id_group,amount,job_id) 
values(20,'E20',5,10,5);

SELECT id_group,
  SUM(DECODE(job_id,1,11, 2,12, 3,13, 40)) sum_val
FROM test_123
GROUP BY id_group
ORDER BY id_group;


SELECT id_group,
  SUM(
  CASE job_id
    WHEN 1
      THEN 11
    WHEN 2
      THEN 12
    WHEN 3
      THEN 13
    ELSE 40
  END) sum_val
FROM test_123
GROUP BY id_group
ORDER BY id_group;

```


```sql

CREATE TABLE PRODUCTS
(
       PRODUCT_ID     INTEGER,
       PRODUCT_NAME   VARCHAR2(30)
);
CREATE TABLE SALES
(
       SALE_ID        INTEGER,
       PRODUCT_ID     INTEGER,
       YEAR           INTEGER,
       Quantity       INTEGER,
       PRICE          INTEGER
);       

INSERT INTO PRODUCTS VALUES ( 100, 'Nokia');
INSERT INTO PRODUCTS VALUES ( 200, 'IPhone');
INSERT INTO PRODUCTS VALUES ( 300, 'Samsung');
INSERT INTO PRODUCTS VALUES ( 400, 'LG');

INSERT INTO SALES VALUES ( 1, 100, 2010, 25, 5000);
INSERT INTO SALES VALUES ( 2, 100, 2011, 16, 5000);
INSERT INTO SALES VALUES ( 3, 100, 2012, 8,  5000);
INSERT INTO SALES VALUES ( 4, 200, 2010, 10, 9000);
INSERT INTO SALES VALUES ( 5, 200, 2011, 15, 9000);
INSERT INTO SALES VALUES ( 6, 200, 2012, 20, 9000);
INSERT INTO SALES VALUES ( 7, 300, 2010, 20, 7000);
INSERT INTO SALES VALUES ( 8, 300, 2011, 18, 7000);
INSERT INTO SALES VALUES ( 9, 300, 2012, 20, 7000);
COMMIT;


select product_id,
       year,
       price,
       lag(Price,1,99999999999999999999) over(partition by product_id order by price desc) previosu_price,
       case 
          when lag(Price,1,99999999999999999999) over(partition by product_id order by price desc)> price then 1
          else 0
        end du
  from 
    (select distinct product_id,
                    year,
                    quantity*price Price
        from SALES
        order by product_id,year) temp_sale;
```
