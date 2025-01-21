n, s, r, m, ret = int(input()), input(), 31, 1234567891, 0
for i in range(n):
    ret += ((ord(s[i]) - ord('a')+1) * (r ** i)) % m
print(ret)