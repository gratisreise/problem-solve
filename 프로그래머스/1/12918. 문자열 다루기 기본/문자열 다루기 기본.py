def solution(s):
    if len(s) != 4 and len(s) != 6: return False
    for c in s:
        if not c.isdigit(): return False
    return True