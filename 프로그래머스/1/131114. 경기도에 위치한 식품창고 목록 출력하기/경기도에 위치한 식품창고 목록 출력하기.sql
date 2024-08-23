# Nullable: ADDRESS, TLNO, FREEZER_YN
# 조건: 위치-경기도인 id, 이름, 주소, 냉동시설여부: NULL => 'N'
SELECT warehouse_id, warehouse_name, address, IFNULL(freezer_yn, 'N') as freezer_yn
FROM food_warehouse
WHERE warehouse_name LIKE '%경기%'
ORDER BY warehouse_id