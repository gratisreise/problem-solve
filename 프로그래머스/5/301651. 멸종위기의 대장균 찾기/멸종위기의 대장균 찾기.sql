WITH RECURSIVE cte AS (SELECT id, parent_id, 1 AS gen
                       FROM ecoli_data
                       WHERE parent_id IS NULL

                       UNION ALL

                       SELECT e.id, e.parent_id, cte.gen + 1 AS gen
                       FROM ecoli_data e
                                JOIN cte ON cte.id = e.parent_id)
SELECT COUNT(a.id) AS 'COUNT', a.gen AS generation
FROM cte a
         LEFT JOIN cte b ON a.id = b.parent_id
WHERE b.id IS NULL
GROUP BY a.gen
ORDER BY a.gen