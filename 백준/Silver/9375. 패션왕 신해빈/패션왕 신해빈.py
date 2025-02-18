from collections import defaultdict
t = int(input())
for _ in range(t):
    n = int(input())
    cloths = defaultdict(int)
    for _ in range(n):
        name,kind = input().split()
        cloths[kind] += 1
    ret = 1
    for key in cloths.keys():
        ret *= (cloths[key] + 1)
    ret -= 1
    print(ret)