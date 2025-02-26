t = int(input())
for _ in range(t):
    n = int(input())
    idx, cnt5 = 1, 0 
    while 5 ** idx <= n:
        cnt5 += n // (5**idx)
        idx += 1
    print(cnt5)