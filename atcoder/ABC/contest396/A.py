n = int(input())
nums = list(map(int, input().split()))
for i in range(1,len(nums)-1):
    if nums[i-1] == nums[i] == nums[i + 1]:
        print("Yes")
        exit()
print("No")