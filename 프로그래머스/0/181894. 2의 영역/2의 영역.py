def solution(arr):
    start = -1
    end = -1
    for i, num in enumerate(arr):
        if num == 2 and start == -1:
            start, end  = i, i 
        elif num == 2 and start != -1:
            end = i
    ret = arr[start: end + 1]
    return ret if ret else [-1]
            