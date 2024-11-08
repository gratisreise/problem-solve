def solution(s, n):
    cnt_lower = [chr(ord('a') + i) for i in range(26)]
    cnt_upper = [chr(ord('A') + i) for i in range(26)]
    ret = []
    for c in s:
        if c.isupper():
            ret.append(cnt_upper[(ord(c) - ord('A') + n)%26])
        elif c.islower():
            ret.append(cnt_lower[(ord(c) - ord('a') + n)%26])
        else: ret.append(c)
    return ''.join(ret)
    
"""
알파벳 소문자, 대문자
일정한 거리만큼 민다

"""