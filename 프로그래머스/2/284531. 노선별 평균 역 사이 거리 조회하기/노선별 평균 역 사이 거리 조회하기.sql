SELECT route,
       Concat(Round(Sum(d_between_dist), 1), 'km') TOTAL_DISTANCE,
       Concat(Round(Avg(d_between_dist), 2), 'km') AVERAGE_DISTANCE
FROM   subway_distance
GROUP  BY route
ORDER  BY Round(Sum(d_between_dist), 1) DESC