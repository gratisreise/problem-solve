# grade별 개발자 정보 , 
with cte1 as (
    select 
        d.*,
        group_concat(s.category) as categories,
        group_concat(s.name) as skills
    from skillcodes s join developers d
    on d.skill_code & s.code = s.code 
    group by d.id    
)

select 
    case
        when categories like '%Front End%' and skills like '%Python%' then 'A'
        when skills like '%C#%' then 'B'
        when categories like '%Front End%' then 'C'
    end as grade,
    id, email
from cte1
having grade is not null
order by grade asc, id asc
