def solution(A,B):
    A.sort()
    B.sort(reverse = True)
    ret = 0
    for i in range(len(A)):
        ret += (A[i] * B[i])
    return ret
    
"""
A, B 각각 한 개의 숫자를 뽑아 두 수를 곱한다
이러한 과정을 
"""