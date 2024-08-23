# el 들어가는 개의 아이디와 이름 조회 like %el%, type = dog
SELECT animal_id, name
FROM animal_ins
WHERE animal_type = 'Dog' AND name LIKE '%EL%'
ORDER BY name