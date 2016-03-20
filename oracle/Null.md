
#### NULLS in SQL

Whenever we don’t have a value, we can put a NULL

+ Can mean many things:
  + Value does not exists
  + Value exists but is unknown
  + Value not applicable
  + Etc.
      
+ The schema specifies for each attribute if can be null (nullable attribute) or not

+ How does SQL cope with tables that have NULLs?

#### Null Values

+ For numerical operations, NULL -> NULL:
    + If x = NULL then 4*(3-x)/7 is still NULL

+ For boolean operations, in SQL there are three values:
    + FALSE =  0
    + UNKNOWN =  0.5
    + TRUE =  1

+ If x= NULL then x=“Joe” is UNKNOWN

