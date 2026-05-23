def solution(s):
    ret = []
    for c in s.split(" "):
        if c =='Z':
            ret.pop()
        else: ret.append(int(c))
    return sum(ret)