+ `sqlplus SYSTEM/manager@//192.168.68.9:1521/XE` connect to oracle

+ `clear scr` clear screen

+ `host pwd`

+ `@/Users/debabratatripathy/Desktop/pl1.sql` execute sql file

+ select output 
```
SET TERMOUT OFF
SET VERIFY OFF -- evitar que imprima las sustituciones de variables que realiza
set trimspool on
set linesize 200
set longchunksize 200000 long 200000 pages 0
column txt format a120
```
