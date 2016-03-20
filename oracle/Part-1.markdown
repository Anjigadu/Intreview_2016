
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

