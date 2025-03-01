from itertools import combinations
n, m = map(int, input().split())

a, chi, home = [], [], []

for i in range(n):
    a.append(list(map(int, input().split())))
    for j in range(n):
        if a[i][j] == 1: home.append((i, j))
        elif a[i][j] == 2: chi.append((i, j))
combi = list(combinations(chi, m))
ret = int(1e9)
for arr in combi:
    sum_dis = 0
    for h in home:
        mn = int(1e9)
        for pos in arr:
            dis = abs(h[0] - pos[0]) + abs(h[1] - pos[1])
            mn = min(dis, mn)
        sum_dis += mn
    ret = min(sum_dis, ret)
print(ret)