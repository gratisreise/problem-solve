import sys
ip, op = sys.stdin, sys.stdout

n, m = map(int, ip.readline().split())
ntos, ston = {}, {}

for i in range(n):
    s = ip.readline().rstrip()
    ntos[i+1] = s
    ston[s] = i+1
for i in range(m):
    s = ip.readline().rstrip()
    if s.isalpha():
        op.write(f"{ston[s]}\n")
    else:
        op.write(f"{ntos[int(s)]}\n")