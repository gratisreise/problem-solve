n, k = map(int, input().split())
nums = list(map(int, input().split()))

current_sum = sum(nums[:k])
max_sum = current_sum

left = 0 #왼쪽 포인터
for right in range(k, n): # 오른쪽 포인터
    current_sum += nums[right] - nums[left]
    max_sum = max(max_sum, current_sum)
    left += 1 #왼쪽 포인터 갱신
    

print(max_sum)

"""
투포인터
"""