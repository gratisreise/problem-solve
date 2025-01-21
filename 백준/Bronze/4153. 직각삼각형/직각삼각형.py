while 1:
    a, b, c = sorted(list(map(int, input().split())))
    if a == b == c == 0: break
    print("right" if c**2 == a**2 + b**2 else "wrong")