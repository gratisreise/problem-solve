def spplit(s):
    nums = [str(i) for i in range(10)]
    temp = ''
    ret = []
    for c in s:
        if c not in nums:
            if temp:
                ret.append(int(temp))
            temp = ''
            continue
        else: temp += c
    if temp: ret.append(int(temp))
    return ret

def solution(my_string):
    ints = spplit(my_string)
    return sum(int(x) for x in ints)    