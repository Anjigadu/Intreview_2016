+ [Analytic functions by Example](http://www.orafaq.com/node/55)

+ [WINDOWING CLAUSE ORACLE ANALYTIC FUNCTIONS WINDOWING CLAUSE](http://nyoug.org/Presentations/SIG/Web/201206_stober_ppt.pdf)

+ [On Top-n and Pagination Queries](http://www.oracle.com/technetwork/issue-archive/2007/07-jan/o17asktom-093877.html)



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
