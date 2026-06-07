def solution(k, score):
    l, ret = [], []
    for num in score:
        if len(l) < k:
            l.append(num)
            l.sort(key= lambda x:-x)
        else:
            if num > l[-1]:
                l[-1] = num
                l.sort(key= lambda x:-x)
        ret.append(l[-1])
    return ret
            
                
"""
top-k => 명전,

"""