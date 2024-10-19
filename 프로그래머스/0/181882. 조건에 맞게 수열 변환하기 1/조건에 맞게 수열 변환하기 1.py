def solution(arr):
    for i in range(len(arr)):
        if arr[i] >= 50 and not(arr[i] & 1): arr[i] /= 2
        elif arr[i] < 50 and arr[i] & 1: arr[i] *= 2
    return arr