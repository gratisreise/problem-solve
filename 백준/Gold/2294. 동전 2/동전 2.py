import sys
input = sys.stdin.readline

# 입력 처리
n, k = map(int, input().split())
INF = int(1e9)
dp = [INF] * (k + 1)  # dp 배열, k까지 필요
dp[0] = 0  # 0원은 0개 동전

# 동전 입력 및 DP 계산
for i in range(n):
    coin = int(input())
    for j in range(coin, k + 1):
        dp[j] = min(dp[j], dp[j - coin] + 1)

# 출력
print(dp[k] if dp[k] != INF else -1)