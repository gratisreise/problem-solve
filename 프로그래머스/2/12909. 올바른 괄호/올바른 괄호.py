def solution(s):
    stk = []
    for c in s:
        if stk and stk[-1] == '(' and c == ')':
            stk.pop()
        else: 
            stk.append(c)
    return True if not stk else False