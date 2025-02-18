import sys
ip, op = sys.stdin, sys.stdout

n,m = map(int, ip.readline().split())
ret = {}
for _ in range(n):
    add, password = ip.readline().rstrip().split()
    ret[add] = password
for _ in range(m):
    s = ip.readline().rstrip()
    op.write(f'{ret[s]}\n')