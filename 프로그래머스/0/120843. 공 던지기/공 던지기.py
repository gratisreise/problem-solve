def solution(numbers, k):
    idx = 0
    cnt = 1
    while k > 0:
        if cnt == k: break
        idx = (idx + 2) % len(numbers)
        cnt += 1
    return numbers[idx]
    