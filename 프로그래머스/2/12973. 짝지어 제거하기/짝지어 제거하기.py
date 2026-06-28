def solution(s):
    ret = []
    for c in s:
        if ret and c == ret[-1]:
            ret.pop()
        else:
            ret.append(c)

    return 0 if ret else 1
    