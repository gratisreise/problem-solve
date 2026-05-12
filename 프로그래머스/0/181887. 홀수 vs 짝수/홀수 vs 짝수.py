def solution(num_list):
    ret1, ret2 = 0, 0
    for i,x in enumerate(num_list):
        if (i + 1) % 2 == 1:
            ret1 += x
        else: ret2 += x
    return ret1 if ret1 >= ret2 else ret2