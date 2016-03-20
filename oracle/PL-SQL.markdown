`Variable Declaration/Initialization`
----
```plsql
SET SERVEROUTPUT ON

DECLARE
  A INTEGER;
  B INTEGER  := 20;
  C INTEGER;
  
BEGIN
    
    A := 10;
    C := A + B;
    DBMS_OUTPUT.PUT_LINE('Value of C' || C);
END;
/
```

`Goto Statement`
----
```plsql
SET SERVEROUTPUT ON

BEGIN
  IF 5 = 5 THEN
    DBMS_OUTPUT.PUT_LINE('I am in IF block');
    goto end_bl;
  ELSIF 6 > 5 THEN
    goto end_bl;
    DBMS_OUTPUT.PUT_LINE('I am in ELIF block');
  ELSE
     DBMS_OUTPUT.PUT_LINE('I am in ELSE block');
  END IF;
  
  <<end_bl>>
   DBMS_OUTPUT.PUT_LINE('I Come to END >>>');
  null;
END;
/
```
`Conditional Logic`
----
```plsql
SET SERVEROUTPUT ON

BEGIN
  IF 5 <> 5 THEN
    DBMS_OUTPUT.PUT_LINE('I am in IF block');
  ELSIF 6 > 5 THEN
    DBMS_OUTPUT.PUT_LINE('I am in ELIF block');
  ELSE
     DBMS_OUTPUT.PUT_LINE('I am in ELSE block');
  END IF;
END;
/
```

`Loop/Iteration`
----
```plsql
SET SERVEROUTPUT ON
BEGIN
    
  FOR CNTR IN 1..5 LOOP
    DBMS_OUTPUT.PUT_LINE('Value of CNTR' || CNTR);
  END LOOP;
END;
/
```

`SQL Select Query`
----
```plsql
set serveroutput on
declare
  l_name varchar(100);
begin
  select KP_NAME into l_name from KP where KP_PK=4737;
  dbms_output.put_line('l_name : ' || l_name);
end;
/

set serveroutput on
declare
  l_name KP.KP_NAME%TYPE;
begin
  select KP_NAME into l_name from KP where KP_PK=4737;
  dbms_output.put_line('l_name : ' || l_name);
end;
/

set serveroutput on
declare
  l_name KP%rowtype;
begin
  select * into l_name from KP where KP_PK=4737;
  dbms_output.put_line('l_name : ' || l_name.KP_NAME);
  dbms_output.put_line('l_pk : ' || l_name.KP_PK);
end;
/
```

`Procedure`
----
```plsql
SET serveroutput ON;
CREATE OR REPLACE
PROCEDURE abc(
    x IN NUMBER,
    y IN NUMBER,
    z OUT NUMBER)
IS
  l_salary INTEGER;
BEGIN
  l_salary:= 40;
  dbms_output.put_line('l_salary : ' || l_salary);
  IF x < y THEN
    z := x;
  ELSE
    z:= y;
  END IF;
END;
/

SET serveroutput ON;
DECLARE
  a NUMBER;
  b NUMBER;
  c NUMBER;
BEGIN
  dbms_output.put_line('Procedure calling start --- ');
  a:= 23;
  b:= 45;
  abc(a, b, c);
  dbms_output.put_line(' Minimum of (23, 45) : ' || c);
END;
/
```
`Function`
----
```plsql
SET serveroutput ON;
create or replace
FUNCTION  abcFunc(
    x IN NUMBER,
    y IN NUMBER,
    z out number)
RETURN number IS
  l_salary INTEGER;
BEGIN
  l_salary:= 40;
  dbms_output.put_line('l_salary : ' || l_salary);
  IF x < y THEN
    z := x;
  ELSE
    z:= y;
  end if;
  return l_salary;
END;
/

SET serveroutput ON;
DECLARE
  a NUMBER;
  b NUMBER;
  c number;
  c_return NUMBER;
BEGIN
  dbms_output.put_line('Procedure calling start --- ');
  a:= 23;
  b:= 45;
  c_return:= abcFunc(a, b, c);
  dbms_output.put_line(' Minimum of (23, 45) : ' || c);
  dbms_output.put_line(' Minimum of (23, 45) : ' || c_return);
END;
```

`Cursor`
----
```plsql
SET serveroutput ON
DECLARE
  CURSOR KP_cur
  is
    SELECT * FROM KP  where KP_PK in (4737,4738,4739);
  KP_rec KP_cur%rowtype;
BEGIN
  OPEN KP_cur;
  LOOP
    FETCH KP_cur INTO KP_rec ;
    EXIT
  WHEN KP_cur%notfound;
    dbms_output.put_line(KP_rec.Name|| ' ' || KP_rec.PK);
  END LOOP;
END;
/
```
`Exception Handling`
----
```plsql
SET serveroutput ON;
DECLARE
  CURSOR KP_cur
  is
    SELECT * FROM KP;
  KP_rec KP_cur%rowtype;
   -- user defined exception
   ex_invalid_id  EXCEPTION;
begin
  raise ex_invalid_id;
  OPEN KP_cur;
  LOOP
    FETCH KP_cur INTO KP_rec;
    EXIT
  when KP_cur%notfound;
    --dbms_output.put_line(KP_rec.txt_namownaccount 
--|| ' ' || KP_rec.nbr_ownaccount);
  END LOOP;
  
  EXCEPTION
   WHEN no_data_found THEN
      dbms_output.put_line('No such customer!');
    when ex_invalid_id then
      dbms_output.put_line('No such ex_invalid_id!');
   when others then
      dbms_output.put_line('Error!'); 
END;
/
```

`Record`
----
```plsql

SET SERVEROUTPUT ON;

DECLARE
  TYPE RECORD_TYPE_NAME IS RECORD (
    T_ID NUMBER,
    T_NAME VARCHAR2(43)
  );
  
  RECORD_TYPE_INSTANCE RECORD_TYPE_NAME;

BEGIN
  RECORD_TYPE_INSTANCE.T_ID := 1;
  RECORD_TYPE_INSTANCE.T_NAME := '1';
  
  DBMS_OUTPUT.PUT_LINE(RECORD_TYPE_INSTANCE.T_ID 
       || '     ' || RECORD_TYPE_INSTANCE.T_NAME);
END;
```


`Array`
----
```plsql
SET serveroutput ON;
DECLARE 
    -- constant declaration 
    message CONSTANT VARCHAR2(20) := 'Hello, World!'; 
    -- other declarations 
    cntr  INTEGER := 0; 
    lcalc INTEGER := 0; 
    name1 INTEGER; 
    -- array declaration
    TYPE namesarray IS varray(5) OF VARCHAR2(10); 
    TYPE grades IS varray(5) OF INTEGER;
    -- array defintion
    names NAMESARRAY; 
    marks GRADES; 
BEGIN 
    dbms_output.Put_line(message); 
    dbms_output.Put_line('---------------------------'); 
    -- array initialization
    names := Namesarray('Kavita', 'Pritam', 'Ayan', 'Rishav', 'Aziz'); 
    marks := Grades(98, 97, 78, 87, 92);
    -- array looping
    FOR name1 IN 1..names.count LOOP 
        dbms_output.Put_line(Names(name1)); 
    END LOOP; 
    dbms_output.Put_line('---------------------------'); 

    -- normal for loop
    FOR cntr IN 1..5 LOOP
        -- conditional statement
        IF ( cntr = 5 ) THEN 
          lcalc := cntr * 2; 
          dbms_output.Put_line('If lcalc: ' || lcalc); 
        ELSE 
          lcalc := cntr * 0; 
          dbms_output.Put_line('else lcalc: ' || lcalc); 
        END IF; 
    END LOOP; 
    dbms_output.Put_line('lcalc: ' || lcalc); 
END; 

/
```

`Collection`
----
```plsql

SET SERVEROUTPUT ON;

DECLARE
  TYPE RECORD_TYPE_NAME IS RECORD (
    T_ID NUMBER,
    T_NAME VARCHAR2(43)
  );
  
  RECORD_TYPE_INSTANCE RECORD_TYPE_NAME;
  
  TYPE COLLECTION_DECL IS TABLE OF RECORD_TYPE_NAME INDEX BY VARCHAR2(20);
  
  COLLECTION_INSTANCE COLLECTION_DECL;

  

BEGIN
  RECORD_TYPE_INSTANCE.T_ID := 1;
  RECORD_TYPE_INSTANCE.T_NAME := '1';
  
  COLLECTION_INSTANCE('1') := RECORD_TYPE_INSTANCE;
  
  RECORD_TYPE_INSTANCE.T_ID := 2;
  RECORD_TYPE_INSTANCE.T_NAME := '2';
  
  COLLECTION_INSTANCE('2') := RECORD_TYPE_INSTANCE;
  
  DBMS_OUTPUT.PUT_LINE(COLLECTION_INSTANCE('1').T_ID 
       || '     ' || COLLECTION_INSTANCE('1').T_NAME);
  DBMS_OUTPUT.PUT_LINE(COLLECTION_INSTANCE('2').T_ID 
       || '     ' || COLLECTION_INSTANCE('2').T_NAME);
END;
```

`Dynamic SQL`
----
```plsql
SET SERVEROUTPUT ON;
DECLARE
  L_SQL    VARCHAR2(100);
  L_ENAME  ACCOUNTS.NBR_OWNACCOUNT%type;
BEGIN
  L_SQL := 'select gf from tt WHERE gf = :gf';
  EXECUTE IMMEDIATE L_SQL INTO L_ENAME USING 4737;
  DBMS_OUTPUT.PUT_LINE('Value of NNACCOUNT  ' || L_ENAME);
END;
```
