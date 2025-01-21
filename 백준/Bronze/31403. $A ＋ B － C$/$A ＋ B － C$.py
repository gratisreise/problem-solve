nums = [int(input()) for _ in range(3)]
print(sum(nums[:2]) - nums[2], int(''.join(map(str, nums[:2]))) - nums[2], sep='\n')