import sys

ip, op = sys.stdin, sys.stdout

n = int(ip.readline())
m = int(ip.readline())
nums = list(map(int, ip.readline().split()))
nums.sort()

ret = 0
for i in range(n):
    target = m - nums[i]
    # 중복조합 방지를 위해 i+1부터시작
    left, right = i + 1, n - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            ret += 1
            break
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

op.write(str(ret) + '\n') 

"""
시간복잡도: nlogn
이분탐색

"""