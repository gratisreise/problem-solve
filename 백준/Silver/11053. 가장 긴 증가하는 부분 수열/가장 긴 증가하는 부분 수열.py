import sys, bisect
input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))
length  = 0
lis = [0]*n

for num in nums:
    pos = bisect.bisect_left(lis[:length], num)
    if lis[pos] == 0:
        length += 1
    lis[pos] = num
print(length)