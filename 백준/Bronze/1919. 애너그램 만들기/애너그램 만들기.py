s1, s2 = input(), input()
cnt1, cnt2 = [0]*26, [0]*26
for c in s1:
    cnt1[ord(c) - ord('a')] += 1
for c in s2:
    cnt2[ord(c) - ord('a')] += 1
ret = 0
for i in range(26):
    ret += abs(cnt1[i] - cnt2[i])
print(ret)