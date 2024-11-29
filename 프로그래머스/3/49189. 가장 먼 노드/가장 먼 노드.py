from collections import deque

def solution(n, edge):
    vis = [0 for i in range(n)]
    graph = [[] for _ in range(n)]
    ret = 0
    for v in edge:
        a, b = v[0]-1, v[1]-1
        graph[a].append(b)
        graph[b].append(a)
    dq, vis[0] = deque([0]), 1
    
    while dq:
        now = dq.popleft()
        for next in graph[now]:
            if vis[next]: continue
            vis[next] = vis[now] + 1
            dq.append(next)
    mx = max(vis)
    for n in vis:
        if n == mx:
             ret += 1
    return ret
    
            
            
        