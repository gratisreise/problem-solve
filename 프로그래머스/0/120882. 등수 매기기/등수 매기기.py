def solution(score): 
    # 둘이 더한 걸로 등수나열 하고 그 나열 한 것의 마지막 인덱스
    temp = []
    for a in score:
        temp.append(a[0] + a[1])
    temp = sorted(temp, reverse = True)
    ret = []
    for i in score:
        ret.append(temp.index(i[0] + i[1])+1)
    return ret
    