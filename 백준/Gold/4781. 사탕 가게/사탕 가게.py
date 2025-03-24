import sys 
input, write = sys.stdin.readline, sys.stdout.write
while True:
    n, m =input().rstrip().split()
    m1, m2  = map(int, m.split('.'))
    if n == '0':
        break
    n, m = int(n), m1 * 100 + m2
    dp = [0]*(m + 1)
    for _ in range(n):
        c, p = input().rstrip().split()
        p1, p2 = map(int, p.split('.'))
        c, p = int(c), p1 * 100 + p2
        for j in range(p, m + 1):
            dp[j] = max(dp[j], dp[j - p] + c)
    write(f"{dp[m]}\n")