def solution(arr):
    answer = []
    prev = -1
    for x in arr:
        if x == prev:
            continue
        answer.append(x)
        prev = x
    return answer