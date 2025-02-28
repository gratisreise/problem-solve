from collections import deque
s = input()
cnt = [0]*26
for c in s:
    cnt[ord(c)-ord('A')] += 1
flag = 0
for num in cnt:
    if num % 2 == 1: flag += 1
if flag >= 2:
    print("I'm Sorry Hansoo")
    exit()
else:
    ret, mid = deque(), ''
    for i in range(25, -1, -1):
        c = chr(i + ord('A'))
        if cnt[i] % 2 == 1:
            cnt[i] -= 1
            mid = c
        for j in range(0, cnt[i], 2):
            ret.append(c)
            ret.appendleft(c)
    if mid != '':
        pos, ret  = len(ret)//2, list(ret)
        print(''.join((ret[:pos] + [mid] + ret[pos:])))
    else: print(''.join(ret))