n, c = map(int, input().split())
ret, dic = {}, {}
for i,num in enumerate(map(int, input().split())):
    if num not in ret:
        ret[num] = 0
    ret[num] += 1
    if num in dic: continue
    dic[num] = i
ans = []
for num in sorted(ret.keys(), key = lambda x: (-ret[x], dic[x])):
    for _ in range(ret[num]):
        ans.append(str(num))
print(' '.join(ans))