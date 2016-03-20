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
