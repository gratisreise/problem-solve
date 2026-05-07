def solution(n):  
    l,r  = 1, n 
    ret, flag = 0, False
    while l <= r:
        if l * r == n:
            if(l == r): flag = True
            ret += 1
            r -= 1
        elif l * r > n:
            r -= 1
        else:
            l += 1
    if flag: 
        ret = ret * 2 - 1
    else: ret *= 2
    
    return ret