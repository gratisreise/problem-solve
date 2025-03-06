s1, s2 = input().split()
s1, s2 = s1[::-1], s2[::-1]

prev = 0
ret = []
for i in range(max(len(s1), len(s2))):
    n1 = int(s1[i]) if i < len(s1) else 0
    n2 = int(s2[i]) if i < len(s2) else 0
    sum = n1 + n2 + prev
    if sum >= 10:
        sum -= 10
        prev = 1
    else: prev = 0
    ret.append(str(sum))
if prev == 1:
    ret.append('1')
print(''.join(ret[::-1]))