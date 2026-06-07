def solution(answers):
    p1= [1, 2, 3, 4,5]
    p2 = [ 2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    cnt = [0, 0, 0]
    for i, x in enumerate(answers):
        if x == p1[i%len(p1)]: cnt[0] += 1
        if x == p2[i%len(p2)]: cnt[1] += 1
        if x == p3[i%len(p3)]: cnt[2] += 1
    mx = max(cnt)
    return [i+1 for i,x in enumerate(cnt) if x == mx]
    
    
"""


"""