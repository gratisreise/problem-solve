from collections import Counter
def solution(A, B):
    cntA, cntB = Counter(A), Counter(B)
    for c in cntA.keys():
        if cntA[c] != cntB[c]:
            return -1
    cnt = 0
    while A != B:
        A = A[-1] + A[:-1] 
        print(A, B)
        cnt += 1
        if cnt > len(A):
            return -1
    return cnt
    
# 문자열 밀기 =  오른쪽으로 이동
