from collections import Counter

def solution(s):
    cnt1, cnt2 = 0, 0
    while s != '1':
        cnt = Counter(list(s))
        cnt1 += 1
        cnt2 += cnt['0']
        s = cnt['1']
        temp = []
        while s > 0:
            temp.append(s % 2)
            s //= 2
        s = ''.join(str(c) for c in temp[::-1])
        
    return [cnt1, cnt2]
    
    
"""
이진변환횟수, 제거된 0갯수
"""