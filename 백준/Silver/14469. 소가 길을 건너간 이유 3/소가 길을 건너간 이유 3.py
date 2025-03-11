n = int(input())
data = []
for _ in range(n):
    a, t = map(int, input().split())
    data.append((a, t))
data.sort()
ret = data[0][0] + data[0][1]
for a, t in data[1:]:
    if a <= ret:
        ret += t
    else:
        ret = a + t
print(ret)