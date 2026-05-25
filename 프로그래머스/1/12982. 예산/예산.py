def solution(d, budget):
    d.sort()
    cnt = 0
    for x in d:
        budget -= x
        if budget < 0:
            break
        cnt += 1
    return cnt 

"""
금액 다 써야함, 
최대한 많으 부서를 지원해야함 
적은 놈들 부터 먼저 지원하고 남으면 큰놈 지원하기

"""