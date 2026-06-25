def solution(n):
    s = e = 1
    ret = 0
    total = 1
    while s <= n:
        if total == n:
            ret += 1
            total -= s
            s += 1
        elif total < n:
            e += 1
            total += e
        else:
            total -= s
            s += 1
            
    return ret
        

"""
1 = 1
2 = 2
3 = 1 + 2, 3
4 = 4
5 = 2 + 3, 5
6 = 1 + 2 + 3, 6
7 = 3 + 4, 7
8 = 8


"""


