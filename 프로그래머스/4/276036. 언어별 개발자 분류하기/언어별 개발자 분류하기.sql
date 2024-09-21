/*
grade 컬럼 지정
a, b, c로 나눌 수 있게 각 조건에 맞게 작성

*/
WITH FrontEnd AS (
    SELECT CODE 
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
),
C AS ( -- SKILLCODES C# select
    SELECT CODE 
    FROM SKILLCODES
    WHERE NAME = 'C#'
),
Python AS ( -- SKILLCODES Python select
    SELECT CODE 
    FROM SKILLCODES
    WHERE NAME = 'Python'
),
GRADE AS ( -- GRADE 
    SELECT ID, 
    CASE 
        WHEN SKILL_CODE & (SELECT CODE FROM Python) != 0 
                AND 
                (SELECT COUNT(*)   
                 FROM FrontEnd 
                 WHERE SKILL_CODE & CODE != 0) >= 1 THEN 'A' 
        WHEN SKILL_CODE & (SELECT CODE FROM C) >= 1 THEN 'B'
        WHEN (SELECT COUNT(*)
              FROM FrontEnd
              WHERE SKILL_CODE & CODE != 0) >= 1 THEN 'C' 
        ELSE  'D'
    END GRADE 
    FROM DEVELOPERS 
)
SELECT G.GRADE, G.ID, D.EMAIL
FROM GRADE G JOIN DEVELOPERS D
ON G.ID = D.ID 
WHERE G.GRADE != 'D'
ORDER BY 1, 2