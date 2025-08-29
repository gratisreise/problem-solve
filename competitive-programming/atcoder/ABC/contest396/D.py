import sys
from collections import defaultdict
def go(now, vis, labels, graph, sum):
    global n, ret 
    if now == n and sum < ret:
        ret = sum
        return
    for next in graph[now]:
        if vis[next]: continue # 재방문금지
        vis[next] = 1
        if sum == "start":
            go(next, vis, labels, graph, labels[(now, next)])
        else:
            go(next, vis, labels, graph, sum ^ labels[(now, next)])
        vis[next] = 0
        

            
    
input = sys.stdin.readline
n, m = map(int, input().split())
labels = defaultdict(int)
graph = defaultdict(list)
vis = [0]*(n+1)
ret = float('inf')
for _ in range(m):
    a, b, c = map(int, input().split())
    labels[(a,b)] = c
    labels[(b,a)] = c
    graph[a].append(b)
    graph[b].append(a)
vis[1] = 1
go(1, vis, labels, graph, "start")
print(ret)



"""
N(2~10)
m(1 ~ 45)
ui,vi(1~n)
wi(0~2^60)
1-> n 모든 단순경로(한정점 한번)에서 xor합이 최소가 되는 값을 출력
(1,2), (2, 1) == 3
2 -> 1


"""