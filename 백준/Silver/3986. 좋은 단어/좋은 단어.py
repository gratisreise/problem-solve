n = int(input())
ret = 0
for _ in range(n):
    s = input()
    stk = []
    for c in s:
        if stk and stk[-1] == c:
            stk.pop()
        else: stk.append(c)
    if stk: continue
    ret += 1
print(ret)