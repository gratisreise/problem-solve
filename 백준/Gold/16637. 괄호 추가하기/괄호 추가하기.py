def calc(c, a, b):
    if c == '+': return a + b
    elif c == '-': return a - b
    elif c == '*': return a * b

def go(idx, sum):
    if idx == len(oper):
        global ret
        ret = max(ret, sum)
        return
    go(idx+1, calc(oper[idx], sum, nums[idx+1]))
    if idx + 2 <= len(oper):
        temp = calc(oper[idx+1], nums[idx+1], nums[idx+2])
        go(idx+2, calc(oper[idx], sum, temp))


n = int(input())
s = input()
oper, nums, ret = [],[], -int(1e9)

for c in s:
    if c.isdigit(): nums.append(int(c))
    else: oper.append(c)
go(0, nums[0])
print(ret)