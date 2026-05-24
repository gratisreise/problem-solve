def solution(my_string):
    opers = my_string.split(" ")
    ret = int(opers[0])
    prev = ' '
    for i in range(1, len(opers)):
        if opers[i] == '+' or opers[i] == '-':
            prev = opers[i]
        else:
            if prev == '+':
                ret += int(opers[i])
            else:
                ret -= int(opers[i])
    return ret