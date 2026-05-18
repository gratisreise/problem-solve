def solution(myString, pat):
    ret = ''
    for i in range(len(myString)+1):
        if myString[:i].endswith(pat):
            ret = myString[:i]
    return ret
        
