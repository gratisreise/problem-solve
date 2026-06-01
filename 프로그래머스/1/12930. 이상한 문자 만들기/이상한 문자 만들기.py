def solution(s):
    ret = ''
    idx = 0
    for c in s:
        now = c
        if now == ' ':
            idx = 0
        else:
            if idx % 2 == 0:
                now = now.upper()
            else:
                now = now.lower()
            idx += 1
        ret += now
    return ret

            
    