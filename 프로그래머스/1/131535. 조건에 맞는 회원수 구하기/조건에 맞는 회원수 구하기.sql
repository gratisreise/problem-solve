# 2021년 가입, 20<=나이 <= 29
select count(user_id) as users
from user_info
where age >= 20 and age <= 29 and year(joined) = 2021