t = int(input())
for _ in range(t):
    k,n = int(input())+1, int(input())
    dp = [[1, *([0]*(n-1))] for _ in range(k)]
    dp[0] = [i+1 for i in range(n)]
    for i in range(1, k):
        for j in range(1, n):
            dp[i][j] = dp[i][j-1] + dp[i-1][j]
    print(dp[k-1][n-1])