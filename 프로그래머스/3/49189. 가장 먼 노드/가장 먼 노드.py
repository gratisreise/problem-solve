from collections import defaultdict

def solution(n, edge):
    dic = defaultdict(list)
    tree = {i+1:[] for i in range(n)}
    for arr in edge:
        a,b = arr
        tree[a].append(b)
        tree[b].append(a)
    mx, q, vis = -1, [1], [0, 1, *[0 for i in range(n-1)]]
    while q:
        now = q.pop(0)
        for next in tree[now]:
            if vis[next]: continue
            vis[next] = vis[now] + 1
            q.append(next)
            dic[vis[next]].append(next)
            mx = max(mx, vis[next])
    return len(dic[mx])
"""
가장 멀리 떨어진 노드의 갯수
높이가 가장 큰것
탐색을 하면서 
맵에 해당하는 길이의 점을 저장하고, 길이의 최댓값 저장
가장 큰 길이의 
"""