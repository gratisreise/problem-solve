def check(c, a, b):
    if c == '<': return a < b
    if c == '>': return a > b

def go(idx, nums):
    if idx == n:
        global ret_max, ret_min
        ret_max = max(ret_max, ''.join(map(str,nums)))
        ret_min = min(ret_min, ''.join(map(str,nums)))
        return
    for i in range(10):
        if cnt[i]: continue
        if check(s[idx], nums[-1], i):
            cnt[i] = 1
            nums.append(i)
            go(idx+1, nums)
            cnt[i] = 0
            nums.pop()

n, s = int(input()), (input().split())
ret_max, ret_min = '0'*(n+1), '9'*(n+1)
cnt = [0]*10
temp = []
for i in range(10):
    cnt[i] = 1
    temp.append(i)
    go(0, temp)
    cnt[i] = 0
    temp = []
print(ret_max, ret_min, sep='\n')