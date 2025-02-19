n = int(input())
for _ in range(n):
    s1, s2 =  input().split()
    cnt1, cnt2 = [0]*26, [0]*26
    if len(s1) != len(s2):
        print("Impossible")
        continue
    for i in range(len(s1)):
        cnt1[ord(s1[i]) - ord('a')] += 1
        cnt2[ord(s2[i]) - ord('a')] += 1
    flag = True
    for i in range(26):
        if not flag: break
        if cnt1[i] != cnt2[i]:
            flag = False
    print("Possible" if flag else "Impossible")