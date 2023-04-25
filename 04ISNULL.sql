[LEVEL 1]
<경기도에 위치한 식품창고 목록 출력하기>
SELECT warehouse_name
FROM warehouses
WHERE address LIKE '경기도%'
AND warehouse_name LIKE '%식품창고%';

<이름 없는 동물의 아이디>
SELECT animal_id
FROM animal_ins
WHERE name IS NULL

<이름이 있는 동물의 아이디>
SELECT animal_id 
FROM animal_ins 
WHERE name IS NOT NULL 
ORDER BY animal_id;

<나이 정보가 없는 회원 수 구하기>
SELECT COUNT(*) AS count
FROM members
WHERE age IS NULL;

[LEVEL 2]
<NULL 처리하기>
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name'), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
