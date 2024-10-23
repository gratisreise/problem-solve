def solution(l, r):
    ret = []
    for i in range(l, r+1):
        temp = list(str(i))
        if len(temp) == temp.count('5') + temp.count('0'):
            ret.append(i)
    return ret if ret else [-1]