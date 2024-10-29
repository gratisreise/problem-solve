def solution(s):
    stk = []
    for c in s:
        if stk and c == stk[-1]:
            stk.pop()
        else:
            stk.append(c)
    return int(not stk)