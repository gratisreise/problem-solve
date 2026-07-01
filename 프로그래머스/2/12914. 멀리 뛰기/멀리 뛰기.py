def solution(n):
    INF = 2000
    dp = [0] * (INF + 1)
    dp[1] = 1
    dp[2] = 2
    for i in range(3, INF + 1):
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567
    return dp[n]
    
    
    
"""
1 = 1
2 = 2, 1 + 1
3 = 2 + 1, 1 + 1 + 1
4 = 2 + 2, 

"""