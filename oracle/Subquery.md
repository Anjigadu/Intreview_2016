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
