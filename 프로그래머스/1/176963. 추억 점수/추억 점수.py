def solution(name, yearning, photo):
    temp = {x1:x2  for x1, x2 in zip(name, yearning)}
    ret = []
    for p in photo:
        ret. append(sum(temp[nn] for nn in p if temp.get(nn)))
    return ret
    
    
"""
추억점수 = 그리움 점수의 총합 

"""