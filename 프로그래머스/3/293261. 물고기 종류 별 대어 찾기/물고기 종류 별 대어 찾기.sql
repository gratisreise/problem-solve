/*
- 물고기 종류별
- max 크기 물고기의 ID, 물고기 이름, 길이
- 물고기의 ID 오름차
- 10cm 이하의 물고기가 가장 큰 경우 없음
1. 두테이블 조인
2. 그룹핑해서 물고기별 최대길이 서브쿼리 와 조인
3. 서브쿼리와 같은 길이 같은 물고기 이름을 가진것 조인
4. 출력
물고기별 최대 길이 구하기
*/
SELECT I.id, N.FISH_NAME, I.length
FROM FISH_INFO I
JOIN FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
JOIN (
    SELECT N.FISH_NAME, MAX(I.length) AS max_length
    FROM FISH_INFO I
    JOIN FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
    GROUP BY N.FISH_NAME
) max_fish ON N.FISH_NAME = max_fish.FISH_NAME AND I.length = max_fish.max_length
ORDER BY I.id;