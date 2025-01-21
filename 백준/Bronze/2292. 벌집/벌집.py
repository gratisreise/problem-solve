n, k, cnt = int(input()), 6, 1
n -= 1
while n > 0:
    n -= k * cnt
    cnt += 1
print(cnt)