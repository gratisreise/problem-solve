import sys
input = sys.stdin.readline
s = list(input().rstrip())
b = input().rstrip()
if len(s) < len(b):
    print(s)
ret = []
for i, c in enumerate(s):
    if c == b[-1] and len(ret) >= len(b)-1:
        temp = [c]
        for _ in range(len(b)-1):
            temp.append(ret.pop())
        if b != ''.join(temp[::-1]):
            while temp:
                ret.append(temp.pop())
    else:
        ret.append(c)
print(''.join(ret) if ret else "FRULA")
