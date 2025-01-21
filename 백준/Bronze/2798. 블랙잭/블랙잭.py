import itertools 
n, m = map(int, input().split()) 
nums = map(int, input().split())
mx = -1
sums = set(map(lambda x: sum(x), itertools.combinations(nums, 3)))
while sums:
    ssum = sums.pop()
    if ssum <= m and ssum > mx:
        mx = ssum
print(mx)