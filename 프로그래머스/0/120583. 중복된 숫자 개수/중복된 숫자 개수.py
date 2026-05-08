from collections import Counter

def solution(array, n):
    cnt = Counter(array)
    return cnt[n]

    