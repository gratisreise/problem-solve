
def spplit(s):
    deli = ['a', 'b', 'c']
    temp = ''
    ret = []
    for c in s:
        if c in deli:
            if temp:
                ret.append(temp)
            temp = ''
            continue
        temp += c
    if temp:
        ret.append(temp)
    if not ret:
        ret.append("EMPTY")
    return ret
    

def solution(myStr):
    return spplit(myStr)