# NULL: name
# SEX_UPON_INTAKE = Neutered or Spayed는 중성화, 아이디 오름차, 중성화 OX 표시

SELECT ANIMAL_ID, NAME,
    CASE 
        WHEN (SEX_UPON_INTAKE REGEXP ('Neutered|Spayed')) 
        THEN 'O' ELSE 'X' END
        AS 중성화
FROM ANIMAL_INS