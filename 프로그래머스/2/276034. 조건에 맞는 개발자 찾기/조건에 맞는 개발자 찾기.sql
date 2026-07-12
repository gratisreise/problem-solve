select distinct(id), email, first_name, last_name
from developers d
join skillcodes s
on d.skill_code & s.code >= 1
where s.name = 'Python' or s.name = 'C#'
order by id


/*
&이게 맞으면 된는건가??


*/