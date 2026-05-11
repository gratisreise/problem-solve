def solution(arr):
    for i,x in enumerate(arr):
        if x % 2 == 0 and x >= 50:
            arr[i] = x // 2
        elif x % 2 == 1 and x <= 50:
            arr[i] = x * 2
    return arr