import sys
from collections import deque
input = sys.stdin.readline
def dfs(start, vis, team):
    vis[start] = 1
    cnt = 0
    stk = deque()
    stk.append(start)
    while stk:
        now = stk.pop()
        cnt += 1
        for next in graph[now]:
            if vis[next]: continue
            if team[next] != team[start]: continue
            vis[next] = 1
            stk.append(next)
    return cnt


n = int(input())
#인구수
person = {i+1:x for i,x in enumerate(map(int, input().split()))}
#선거구 그래프
graph = {i+1:[] for i in range(n)}
for i in range(n):
    nums = list(map(int, input().split()))
    a = i + 1
    for b in range(1, len(nums)):
        graph[a].append(nums[b])
combs = []
#선거구 조합 갯수
for i in range(1, (1 << n)-1):
    temp = []
    for j in range(n):
        if i & (1 << j):
            temp.append(j+1)
    combs.append(temp)
ret = int(1e9)
# print(combs)
#각 선거구 형태마다
for comb in combs:
    team = [0]*(n +1)
    vis = [0]*(n+1)
    #팀정해주기
    for idx in comb:
        team[idx] = 1
    start_0, start_1 = 0, 0
    for i in range(1, len(team)):
        if team[i] == 1: start_1 = i
        else: start_0 = i
    if dfs(start_1, vis, team) + dfs(start_0, vis, team) == n:
        cnt0, cnt1 = 0, 0
        for i in range(1, len(team)):
            if team[i] == 0: cnt0 += person[i]
            else: cnt1 += person[i]
        ret = min(ret, abs(cnt1 - cnt0))
print(-1 if ret == int(1e9) else ret)
        