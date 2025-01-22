n = int(input())
data = set()
for _ in range(n):
    data.add(input())
data = sorted(data, key=lambda x: (len(x), x))
print('\n'.join(data))