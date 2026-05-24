def solution(a, b):
    a, b = a[::-1], b[::-1]
    ssum = 0
    idx = 0
    ret = ''
    prev = 0
    print(a, b)
    while idx < max(len(a), len(b)):
        na = int(a[idx]) if idx < len(a) else 0
        nb = int(b[idx]) if idx < len(b) else 0
        ssum = na + nb + prev
        if ssum >= 10:
            prev, ssum = 1, ssum-10
        else:
            prev = 0
        ret += str(ssum)
        idx += 1
        
    if prev == 1: ret += "1"
    return ret[::-1]

# 2015793246801012701479981
# 287346502836570928366
# 305793246910280479981