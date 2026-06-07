

def solution(numlist, n):
    return sorted(numlist, key = lambda x: (abs(n - x), -x))

"""
1.n기준 가까운 순으로 정렬
2.거리 같으면 큰수가 앞으로 오도록 배치
3.
"""