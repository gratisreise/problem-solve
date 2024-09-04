-- 코드를 입력하세요
WITH recursive time
AS
  (
         SELECT 0 AS hour
         UNION ALL
         SELECT hour + 1
         FROM   time
         WHERE  hour < 23)
         
  SELECT     time.hour ,
             count(animal_id)
  FROM       (
                    SELECT * ,
                           hour(datetime) AS hour
                    FROM   animal_outs) AS outs2
  RIGHT JOIN time
  ON         outs2.hour = time.hour
  GROUP BY   time.hour
  ORDER BY   time.hour