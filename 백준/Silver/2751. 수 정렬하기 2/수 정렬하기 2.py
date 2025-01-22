import sys
ip, op = sys.stdin, sys.stdout
n, data = int(ip.readline()), []
for _ in range(n):
    data.append(int(ip.readline()))
data.sort()
op.write('\n'.join(map(str,data)) +'\n')