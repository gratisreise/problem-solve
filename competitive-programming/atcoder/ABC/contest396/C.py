import sys
input = sys.stdin.readline
n, m = map(int, input().split())
nums_b = list(map(int, input().split()))
nums_w = list(map(int, input().split()))
nums_b = sorted(nums_b, reverse=True)
nums_w = sorted(nums_w, reverse=True)

ret = 0
for i in range(len(nums_b)):
    sum = nums_b[i] + (nums_w[i] if i < len(nums_w) and nums_w[i] > 0 else 0)
    if sum > 0: ret += sum
    else: break
print(ret if ret > 0 else 0)