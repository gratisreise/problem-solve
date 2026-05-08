def solution(my_string):
    ret = 0
    for c in my_string:
        if c.isdecimal():
           ret += int(c)
    return ret