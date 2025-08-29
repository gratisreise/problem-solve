s = list(input())

prev = 'o'
stk = []
ret = 0
for c in s:
    if prev == 'i':
        if c == 'i':
            stk.append('o')
            ret += 1
        stk.append('i')
    else:
        if c == 'o':
            stk.append('i')
            ret += 1
        stk.append('o')
    prev = c
if len(stk) % 2 != 0:
    ret += 1

print(ret)