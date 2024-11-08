def solution(s):
    s = list(s)
    cnt = 0
    for i in range(len(s)):
        if s[i] == ' ':
            cnt = 0
            continue
        s[i] = s[i].lower() if cnt % 2 else s[i].upper()
        cnt += 1
        
    return ''.join(s)