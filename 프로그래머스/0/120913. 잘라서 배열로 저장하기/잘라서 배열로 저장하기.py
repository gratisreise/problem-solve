def solution(my_str, n):
    temp = ''
    ret = []
    for c in my_str:
        if len(temp) == n:
            ret.append(temp)
            temp = c
        else: 
            temp += c
    if temp: 
        ret.append(temp)
    return ret