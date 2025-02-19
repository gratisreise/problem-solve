ret = {0:{x:0 for x in range(1, 7)}, 1:{x:0 for x in range(1, 7)}}
n, k = map(int, input().split())
for _ in range(n):
    s,y = map(int, input().split())
    ret[s][y] += 1
cnt = 0
for s in ret.keys():
    for y in ret[s].keys():
        if ret[s][y] % k == 0:
            cnt += ret[s][y] // k
        else:
            cnt += ret[s][y] // k + 1
print(cnt)