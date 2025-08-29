n = input()
nums = list(map(int, input().split()))

prev = -1
for num in nums:
    if num <= prev:
        print("No")
        exit()
    prev = num
print("Yes")



