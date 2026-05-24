def solution(s):
    print(1)
    if len(s) != 4 and len(s) != 6:
        return False
    st = list(str(x) for x in range(10))
    for c in s:
        if c not in st:
            return False
    
    return True