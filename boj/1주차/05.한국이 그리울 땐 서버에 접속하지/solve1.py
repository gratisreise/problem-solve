n = int(input())
pattern = input()
pos = pattern.find('*')
pre_ptn = pattern[:pos]
suf_ptn = pattern[pos + 1:]

#검증
for _ in range(n):
    s = input()
    if len(s) < len(pre_ptn) + len(suf_ptn):
        print('NE')
    else:
        if s.startswith(pre_ptn) and s.endswith(suf_ptn):
            print("DA")
        else: print("NE")


"""
"""