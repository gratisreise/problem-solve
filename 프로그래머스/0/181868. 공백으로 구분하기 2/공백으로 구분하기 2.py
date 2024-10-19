def solution(my_string):
    strings = my_string.strip().split(" ")
    ret = []
    for s in strings: 
        if s == '': continue 
        ret.append(s)
    return ret
    