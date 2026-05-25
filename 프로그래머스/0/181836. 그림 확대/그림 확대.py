def solution(picture, k):
    row = len(picture) * k
    ret = []
    for s in picture:
        temp = ''
        for c in s:
            temp += (c*k)
        for _ in range(k):
            ret.append(temp)
    return ret
            
            