


create table INIT_ID
(
  TABLE_NAME    VARCHAR2(64) not null,
  COLUMN_NAME   VARCHAR2(64) not null,
  SCHEMA_NAME   VARCHAR2(64) not null,
  DATA_TYPE     VARCHAR2(1),
  ID_LENGTH     NUMBER,
  REF_CODE      NUMBER,
  REF_TYPE      VARCHAR2(1),
  CURRENT_VALUE NUMBER,
  ID_STEP       NUMBER
)



create or replace procedure SequenceProc(tableName in VARCHAR2,columnName IN VARCHAR2,schemaName IN varchar2,  COUNTNUM IN INTEGER, resultStr OUT VARCHAR2 )
as
--定义变量
result_str VARCHAR2 (1000);
currentId NUMBER := -1;
idStep INTEGER := -1;
i INTEGER := 0;
lock_result INTEGER;
begin

SELECT
    t.CURRENT_VALUE,
    t.ID_STEP
INTO
    currentId,
    idStep
FROM
    init_id t
WHERE
    t.TABLE_NAME = tableName
AND t.SCHEMA_NAME = schemaName
AND t.COLUMN_NAME = columnName
FOR UPDATE;


--#返回结果集处理
IF currentId = -1 THEN
    --#如果没有查询到相应的记录，返回空值给客户端
     result_str := '';
ELSE
     result_str := '';
WHILE i<COUNTNUM loop
BEGIN
     currentId:=currentId+idStep;
--#当第一次添加的时候，不用加','
IF i = 0 THEN
     result_str := currentId;
ELSE
     result_str := result_str||','||currentId;
END IF;
 i:=i+1;
END;
END loop;
--#修改ID表的信息
UPDATE
    init_id t
SET
    t.CURRENT_VALUE=currentId
WHERE
    t.TABLE_NAME = tableName
AND t.SCHEMA_NAME = schemaName
AND t.COLUMN_NAME = columnName;
COMMIT;
 resultStr:=result_str;
END IF;
--SET lock_result=release_lock('sp_critical_section_lock');




end SequenceProc;
