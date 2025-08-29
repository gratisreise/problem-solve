from collections import defaultdict
t = int(input())
for _ in range(t):
    n = int(input())
    clothes = defaultdict(int)
    for _ in range(n):
        _, kind = input().split()
        clothes[kind] += 1
    ret = 1
    for key in clothes.keys():
        ret *= (clothes[key] + 1)
    ret -= 1
    print(ret)