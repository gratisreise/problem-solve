def solution(box, n):
    box = [num//n for num in box]
    ret = 1
    for num in box:
        ret *= num
    return ret
    