import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    a.sort(), b.sort()
    idx, ret = 0, 0
    for numa in a:
        while idx < m and b[idx] < numa:
            idx += 1
        if idx == m:
            ret += m
            continue
        if b[idx] >= numa:
            ret += idx
        else:
            ret += idx + 1
    print(ret)