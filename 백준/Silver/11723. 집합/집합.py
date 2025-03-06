import sys
input, output = sys.stdin.readline, sys.stdout.write
n = int(input())

st = set()
for i in range(n):
    cmd = input().rstrip().split()
    if cmd[0] == 'add':
        a = int(cmd[1])
        if a in st: continue
        st.add(a)
    elif cmd[0] == 'remove':
        a = int(cmd[1])
        if a not in st: continue
        st.discard(a)
    elif cmd[0] == 'check':
        a = int(cmd[1])
        if a in st: output('1\n')
        else: output('0\n')
    elif cmd[0] == 'toggle':
        a = int(cmd[1])
        if a in st: st.discard(a)
        else: st.add(a)
    elif cmd[0] == 'all':
        st = {x for x in range(1, 21)}
    elif cmd[0] == 'empty':
        st.clear()