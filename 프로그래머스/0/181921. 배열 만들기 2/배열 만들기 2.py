def solution(l, r):
    ret = []
    for i in range(l, r + 1):
        flag = False
        for c in str(i):
            if c != '0' and c != '5':
                flag = True
            if flag:
                break
        if not flag:
            ret.append(i)
    return [-1] if not ret else ret