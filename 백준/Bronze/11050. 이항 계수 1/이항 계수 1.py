n, k = map(int, input().split())
k, ret = min(n-k, k), 1
for i in range(k):
    ret *= (n-i)
    ret //= (i+1)
print(ret)