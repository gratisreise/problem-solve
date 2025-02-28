def go(a, b, c):
    if b == 1: return a % c
    ret = go(a, b//2, c)
    ret = (ret * ret) % c
    if b % 2 == 1: ret *= a
    return ret % c
a, b, c = map(int, input().split())
print(go(a, b, c))