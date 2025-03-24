import sys
input = sys.stdin.readline
dp = [0] * 101
n = int(input())
health = list(map(int, input().split()))
happy = list(map(int, input().split()))

for h,p in zip(health, happy):
    for j in range(h, 100):
        dp[j-h] = max(dp[j] + p, dp[j-h])
print(dp[0])