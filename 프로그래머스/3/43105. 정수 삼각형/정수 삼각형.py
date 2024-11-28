def solution(triangle):
    dp = [[0, *t, 0] for t in triangle]
    for i in range(1, len(triangle)):
        for j in range(1, i + 2):
            dp[i][j] += max(dp[i - 1][j - 1], dp[i - 1][j])
            
    return max(dp[-1])
"""
아이디어 높이를 내려가면서 이전 높이에서 받을 수 있는 값중 큰값만 받기

"""