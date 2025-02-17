import sys
ip, op = sys.stdin, sys.stdout

nums = [int(ip.readline()) for i in range(9)]
a,b, sums = 0, 0, sum(nums)
for i in range(9):
    for j in range(i + 1, 9):
        if sums - nums[i] - nums[j] == 100:
            a,b = i, j
nums = sorted([nums[i] for i in range(9) if i != a and i != b])
op.write('\n'.join(map(str, nums))+'\n')
"""
키의 합이 100, 
일곱난쟁이 찾기

1. 두명을 골르는 조합
    1-1. 총합에서 두명을 빼기
2. 두명 빼고 저장
3. 정렬후 출력

"""