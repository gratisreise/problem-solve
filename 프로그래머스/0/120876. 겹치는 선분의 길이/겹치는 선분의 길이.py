def solution(lines):
    cnt = [0] * 201
    for line in lines:
        a, b = line
        for i in range(a, b):
            cnt[i+100] += 1
    return sum(1 for i in cnt if i >= 2)