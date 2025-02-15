import sys
ip, op = sys.stdin, sys.stdout
ret = []
while True:
    s = ip.readline().rstrip()
    if s == '.': break
    stk, case = [], ['[',']', '(', ')']
    for c in s:
        if c in case:
            if c == '[' or c == '(':
                stk.append(c)
            elif stk and c == ')' and stk[-1] == '(':
                stk.pop()
            elif stk and c == ']' and stk[-1] == '[':
                stk.pop()
            else:
                stk.append(c)
    ret.append('no' if stk else 'yes')
op.write('\n'.join(ret) + '\n')