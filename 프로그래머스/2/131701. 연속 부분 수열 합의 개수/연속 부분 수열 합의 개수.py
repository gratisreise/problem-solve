from collections import deque
def solution(elements):
    ret = set()
    for i in set(elements):
        ret.add(i)
    ret.add(sum(elements))
    n = len(elements)
    for i in range(2, n):
        for _ in range(n):
            ret.add(sum(elements[0:i]))
            elements = elements[1:] + elements[:1]
    return len(ret)
"""
리스트를 돌려가면서 rotate로 계속돌릴까
연속 부분 수열의 합
2 ~ n-2


"""