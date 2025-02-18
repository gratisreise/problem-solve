import sys
ip, op = sys.stdin, sys.stdout
def convert(s):
    return int(s[:2])*60 + int(s[3:])

s,e,q =  ip.readline().rstrip().split()

ret = set()
cnt = 0
while True:
    line = ip.readline().rstrip().split()
    if not line: break
    t, name = line
    if convert(t) <= convert(s):
        ret.add(name)
    elif convert(e) <= convert(t) <= convert(q):
        if name in ret:
            cnt += 1
            ret -= {name}
print(cnt)