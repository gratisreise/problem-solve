def solution(my_string, queries):
    ss = list(my_string)
    for q in queries:
        s, e = q
        while s < e:
            temp = ss[s]
            ss[s] = ss[e]
            ss[e] = temp
            s += 1
            e -= 1
    return ''.join(ss)
        
        