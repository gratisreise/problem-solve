n, m = map(int, input().split())
ret = [[0] * m for _ in range(n)]
for _ in range(2):
    for i in range(n):
        l = list(map(int, input().split()))
        for j in range(m):
            ret[i][j] += l[j]
for i in range(n):
    print(' '.join(map(str, ret[i])))