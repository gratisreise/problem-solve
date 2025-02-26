n = int(input())
a = []
def go(y, x, size):
    if size == 1: return a[y][x]
    b = a[y][x]
    ret = []
    for i in range(y, y + size):
        for j in range(x, x + size):
            if a[i][j] != b:
                ret.append('(')
                ret.append(go(y,x, size//2))
                ret.append(go(y,x + size//2, size//2))
                ret.append(go(y + size//2, x, size//2))
                ret.append(go(y + size//2, x + size//2, size//2))
                ret.append(')')
                return(''.join(ret))
    return a[y][x]

for _ in range(n):
    a.append(list(input()))

print(go(0, 0, n))