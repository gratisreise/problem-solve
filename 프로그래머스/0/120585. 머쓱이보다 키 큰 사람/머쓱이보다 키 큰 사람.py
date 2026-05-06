def solution(arr, h):
    num = 0
    for n in arr: 
        if n > h: 
            num += 1
    return num