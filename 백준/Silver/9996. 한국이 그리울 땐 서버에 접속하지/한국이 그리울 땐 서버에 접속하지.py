n = int(input())
pattern = input()
pos = pattern.index('*')
pre_ptn = pattern[:pos]
suf_ptn = pattern[pos+1:]

for _ in range(n):
    s = input()
    if len(s) < len(pre_ptn) + len(suf_ptn):
        print('NE')
    else:
        if s[:len(pre_ptn)] == pre_ptn and s[len(s) - len(suf_ptn):] == suf_ptn:
            print('DA')
        else: print('NE')