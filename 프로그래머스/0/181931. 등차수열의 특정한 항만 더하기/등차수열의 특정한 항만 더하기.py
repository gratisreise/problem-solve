def solution(a, d, included):
    return sum((a + d*i) for i in range(len(included)) if included[i])