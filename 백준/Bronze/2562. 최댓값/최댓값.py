mx, mx_idx = -1, -1
for i in range(9):
    n = int(input())
    if mx < n:
        mx, mx_idx = n, i + 1
print(mx)
print(mx_idx)