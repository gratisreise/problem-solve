import sys

input = sys.stdin.readline

n = int(input())
u = [int(input()) for _ in range(n)]
u.sort()

sums = set()
for i in range(n):
    for j in range(i, n):
        sums.add(u[i] + u[j])

ans = 0
for i in range(n - 1, -1, -1):
    for j in range(i + 1):
        if u[i] - u[j] in sums:
            print(u[i])
            sys.exit()
print(-1)