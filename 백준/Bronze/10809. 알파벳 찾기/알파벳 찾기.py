s = input()
cnt = [-1] * 26
for i,c in enumerate(s):
    temp = ord(c) - ord('a')
    if cnt[temp] == -1: cnt[temp] = i
print(*cnt)