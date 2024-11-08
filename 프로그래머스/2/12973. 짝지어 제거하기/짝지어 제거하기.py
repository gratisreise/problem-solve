def solution(s):
    stk = []
    for c in s:
        if stk and stk[-1] == c: stk.pop()
        else: stk.append(c)
    return 0 if stk else 1
"""
1. 같은 문자열이 있으면 팝
2. 문자열이 없으면 1 아니면 0 반환
"""