from collections import deque
import sys
ip, op = sys.stdin, sys.stdout
stk, ret = [], []
n = int(ip.readline())
temp = 0
flag = True
for _ in range(n):
    num = int(ip.readline())
    while temp < num:
        temp += 1
        stk.append(temp)
        ret.append('+')
    if stk and stk[-1] != num:
        flag = False
    elif stk and stk[-1] == num:
        stk.pop()
        ret.append('-')
print('\n'.join(ret) if flag else 'NO')