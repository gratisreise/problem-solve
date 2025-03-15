from bisect import bisect_left
n = int(input())
nums = []
for _ in range(n):
    nums.append(tuple(map(int, input().split())))
nums.sort()
nums = [x[1] for x in nums]
lis = [0]*n
length = 0
for num in nums:
    pos = bisect_left(lis, num, 0, length)
    if lis[pos] == 0:
        length += 1
    lis[pos] = num
print(n - length)