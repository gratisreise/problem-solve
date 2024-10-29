def check(s):
    stk = []
    for c in s:
        if not stk and (c == ')' or c == '}' or c == ']'):
             return False
        if c == '(' or c == '[' or c == '{':
            stk.append(c)
        elif c == ')' and stk[len(stk)-1] == '(':
            stk.pop()
        elif c == ']' and stk[len(stk)-1] == '[':
            stk.pop()
        elif c == '}' and stk[len(stk)-1] == '{':
            stk.pop()
    return False if stk else True
def solution(s):
    ret = 0
    for i in range(len(s)):
        if(check(s[i:]+s[:i])): ret += 1
    return ret