import sys
input = sys.stdin.readline

# 입력 처리
n, m, c = map(int, input().split())
a = [[0] * (m + 1) for _ in range(n + 1)]  # 1-based 격자
dp = [[[[-1] * (c + 1) for _ in range(c + 1)] for _ in range(m + 1)] for _ in range(n + 1)]  # 4D DP 배열
mod = 1000007

# 번호 입력
for i in range(1, c + 1):
    y, x = map(int, input().split())
    a[y][x] = i

# DP 함수
def go(y, x, cnt, prev):
    if y > n or x > m:  # 범위 벗어남
        return 0
    if y == n and x == m:  # 목표 도달
        if cnt == 0 and a[y][x] == 0:
            return 1
        if cnt == 1 and a[y][x] > prev:
            return 1
        return 0
    
    ret = dp[y][x][cnt][prev]
    if ret != -1:  # 메모이제이션
        return ret
    
    ret = 0
    if a[y][x] == 0:  # 번호 없음
        ret = (go(y + 1, x, cnt, prev) + go(y, x + 1, cnt, prev)) % mod
    elif a[y][x] > prev:  # 번호 있고 오름차순 만족
        ret = (go(y + 1, x, cnt - 1, a[y][x]) + go(y, x + 1, cnt - 1, a[y][x])) % mod
    
    dp[y][x][cnt][prev] = ret
    return ret

# 출력: 0번부터 C번까지
for i in range(c + 1):
    print(go(1, 1, i, 0), end=" ")