from collections import defaultdict
n, m = map(int, input().split())
ret1 = defaultdict(list)
ret2 = {}
for _ in range(n):
    team, t = input(), int(input())
    for _ in range(t):
        name = input()
        ret1[team].append(name)
        ret2[name] = team
for key in ret1.keys():
    ret1[key].sort()
for _ in range(m):
    string, num = input(), int(input())
    if num == 0:
        print('\n'.join(ret1[string]))
    else:
        print(ret2[string])