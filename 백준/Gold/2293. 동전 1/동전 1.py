import sys
input = sys.stdin.readline

# 입력 처리
n, k = map(int, input().split())
dp = [0] * (k + 1)  # dp 배열, k까지 필요
dp[0] = 1  # 0원은 1가지 방법

# 동전 입력 및 DP 계산
for _ in range(n):
    temp = int(input())
    if temp >= 10001:  # 동전 가치가 k보다 크면 무시
        continue
    for j in range(temp, k + 1):
        dp[j] += dp[j - temp]

# 출력
print(dp[k])