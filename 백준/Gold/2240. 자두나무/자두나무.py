import sys 
sys.setrecursionlimit(10**6)

t, w = map(int, input().split())
a = [int(input()) for _ in range(t)]
dp = [[[-1]*(w+2) for _ in range(2)] for _ in range(t+2)]
def go(time, pos, cnt):
    if cnt < 0: return -100
    if time == t:
        return 0
    if dp[time][pos][cnt] != -1:
        return dp[time][pos][cnt]
    
    dp[time][pos][cnt] = max(
        go(time + 1, pos, cnt),
        go(time + 1, pos^1, cnt -1)
    ) + (1 if pos == a[time]-1 else 0)
    
    return dp[time][pos][cnt]

print(max(go(0,0,w), go(0, 1, w-1)))