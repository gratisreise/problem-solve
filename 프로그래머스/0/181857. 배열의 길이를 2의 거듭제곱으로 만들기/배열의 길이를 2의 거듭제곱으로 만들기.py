def solution(arr):
    idx = 0
    for i in range(0, 11):
        if 2 ** i >= len(arr): 
            idx = i
            break
    return arr + [0] * ((2 **idx) - len(arr))