def count(num):
    cnt = 0
    for i in range(1, num+1):
        if i * i > num: break
        if num % i == 0:
            if i * i == num:
                cnt += 1
            else:
                cnt += 2
    return cnt

def solution(number, limit, power):
    ret = 0
    for i in range(1, number+1):
        if count(i) > limit:
            ret += power
        else:
            ret += count(i)
    return ret
    
    
"""
자신의 기사번호의 약수갯수 공격력
제한수치 이상은 지정무기 들기
필요한 철무게 반환


"""

