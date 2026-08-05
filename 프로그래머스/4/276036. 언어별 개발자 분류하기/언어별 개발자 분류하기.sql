select 
    case
        when group_concat(category) like '%Front End%' and group_concat(name) like '%Python%' then 'A'
        when group_concat(name) like '%C#%' then 'B'
        when group_concat(category) like '%Front End%' then 'C'
        else null
    end as grade,
    d.id,
    d.email
from developers d
join skillcodes s
on d.skill_code & s.code = s.code
group by d.id 
having grade is not null
order by grade asc,  d.id asc



/*


*/