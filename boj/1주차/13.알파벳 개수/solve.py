cnt = [0]*26
for c in input():
    cnt[ord(c) - ord('a')] += 1
print(' '.join(map(str, cnt)))