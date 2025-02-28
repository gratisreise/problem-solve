s = input()
cnt = [0] * 26
for c in s:
    cnt[ord(c) - ord('A')] += 1

odd_count = 0
odd_char = ''

for i in range(26):
    if cnt[i] % 2 != 0:
        odd_count += 1
        odd_char = chr(i + ord('A'))
        cnt[i] -= 1
if odd_count > 1:
    print("I'm Sorry Hansoo")
else:
    ret = ''
    for i in range(26):
        ret += chr(i + ord('A')) * (cnt[i] // 2)
    if odd_char:
        print(ret + odd_char + ret[::-1])
    else:
        print(ret + ret[::-1])