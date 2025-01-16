nums = [0]*31
for _ in range(28):
    nums[int(input())] += 1
for i in range(1, 31):
    if not nums[i]: print(i)