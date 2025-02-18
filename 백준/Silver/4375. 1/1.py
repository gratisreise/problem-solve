import sys
ip, op = sys.stdin, sys.stdout
data = map(int, ip.read().split())
for n in data:
    cnt, num = 1, 1
    while num % n != 0:
        num = 10*num + 1
        num %= n
        cnt += 1
    op.write(f"{cnt}\n")