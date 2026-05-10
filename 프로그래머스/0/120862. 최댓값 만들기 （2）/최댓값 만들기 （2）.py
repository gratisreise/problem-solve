def solution(numbers):
    ret = -1000000000
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j: continue
            ret = max(ret, numbers[i] * numbers[j])
    return ret