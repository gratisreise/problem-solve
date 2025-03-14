from itertools import permutations
n = int(input())
nums = list(map(int, input().split()))
cnts = list(map(int, input().split()))
opers = []
for i, cnt in enumerate(cnts):
    for _ in range(cnt):
        if i == 0:
            opers.append('+')
        elif i == 1:
            opers.append('-')
        elif i == 2:
            opers.append('x')
        elif i == 3:
            opers.append('/')
pers = list(permutations(opers, len(opers)))

def calc(a, b, c):
    if c == '+': return a + b
    elif c == '-': return a - b
    elif c == 'x': return a * b
    elif c == '/': 
        if a < 0 or b < 0:
            return -(abs(a) // abs(b))
        return a // b

ret_mx, ret_mn = -int(1e9)-1, int(1e9)+1
for per in pers:
    total, idx = nums[0], 1
    for op in per:
        total = calc(total, nums[idx], op)
        idx += 1
    ret_mx = max(total, ret_mx)
    ret_mn = min(total, ret_mn)
print(ret_mx, ret_mn, sep = '\n')