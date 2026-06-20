from collections import deque
def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    for e in edge:
        a, b = e
        graph[a].append(b)
        graph[b].append(a)
    
    q = deque()
    visited = [0] * (n + 1)
    q.append(1)
    visited[1] = 1
    mmax = -1
    while q:
        now = q.popleft()
        mmax = max(mmax, visited[now])
        for nex in graph[now]:
            if visited[nex]:
                continue
            q.append(nex)
            visited[nex] = visited[now] + 1
    return sum(1 for x in visited if x == mmax)
        

"""
[조건]
n개의 노드 1~n, 
1번노드 기준 가장 멀리 떨어진 노드의 갯수
가장 멀리 = 최단경로 간선 갯수 가장 많음


[아이디어]
리프 노드를 구하는 것 => 
방문에서 1번을 기준으로 bfs로 채워주면 되지 않을까??

[자료구조]
graph, 방문배열
[로직]
1. vertex를 순회하면서 그래프 생성 
2. bfs 돌면서 visited 채우기
3. 출력 
"""