def solution(sides):
    sides.sort()
    ret = 1
    if sides[-1] >= sides[0] + sides[1]:
        ret = 2
    return ret