nums = []
for _ in range(9):
    nums.append(int(input()))
total = sum(nums)
for i in range(9):
    for j in range(i + 1, 9):
        if total - nums[i] - nums[j] == 100:
            ret = sorted([x for x in nums if x != nums[i] and x != nums[j]])
            print(*ret, sep='\n')
            exit()