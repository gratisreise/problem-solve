while True:
    s = input()
    if s == '0': break
    print("yes" if list(s) == list(s[::-1]) else "no")