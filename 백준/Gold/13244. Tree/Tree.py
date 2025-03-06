import sys
from collections import defaultdict

input = sys.stdin.readline

# DFS로 연결 요소 탐색
def dfs(here, adj, visited):
    visited[here] = True
    for there in adj[here]:
        if not visited[there]:
            dfs(there, adj, visited)

#입력 처리
T = int(input())
for _ in range(T):
    N, M = int(input()), int(input())
    #인접 리스트 초기화
    adj = defaultdict(list)
    for _ in range(M):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)
    
    #방문 배열 초기화
    visited = [False] * (N + 1)
    cnt = 0 #연결 요소 수

    #연결 요소 계산
    for i in range(1, N + 1):
        if not visited[i]:
            dfs(i, adj, visited)
            cnt += 1
    
    #트리 여부 판단
    if M == N - 1 and cnt == 1:
        print("tree")
    else:
        print("graph")


"""
코드 설명
1. 입력 처리:
    - T: 테스트 케이스 수.
    - N, M: 노드 수와 간선 수.
    - adj: 인접 리스트로 간선 입력 (양방향).

2. DFS 함수 (dfs):
    - here: 현재 노드.
    - adj: 인접 리스트.
    - visited: 방문 여부 체크.
    - 재귀적으로 연결된 모든 노드 방문.

3. 메인 로직:
 - 각 테스트 케이스:
    - adj와 visited 초기화.
    - 1부터 N까지 DFS로 연결 요소 수(cnt) 계산.
    - 조건: M == N - 1 (트리 간선 수) && cnt == 1 (단일 연결 요소).

4.출력:
    - 트리면 "tree", 아니면 "graph".


개선점:
고정 배열 대신 defaultdict로 메모리 효율성 개선.
visited 크기를 N+1로 입력에 맞게 동적 조정.


시간 복잡도
DFS: O(N + M) (노드 + 간선).
연결 요소 탐색: O(N) 호출.
총: O(T * (N + M)), T ≤ 100, N ≤ 1000, M ≤ N-1 → 약 O(10^5) → 2초 내 충분.
공간 복잡도
O(N): visited와 adj.


트리 여부를 판단하는 기준
트리는 그래프의 특수한 형태로, 다음 조건을 모두 만족해야 해:

단일 연결 요소:
그래프가 한 덩어리로 연결되어 있어야 함.
즉, 모든 노드가 서로 연결돼 있고, 분리된 부분(연결되지 않은 노드)이 없어야 해.
코드에서 DFS로 연결 요소 수(cnt)를 세는데, cnt == 1이어야 함.
사이클이 없음:
트리에는 순환(사이클)이 없어야 해.
사이클이 없으면 간선 수(M)는 항상 노드 수(N)보다 1 작아야 함: M == N - 1.
이 조건이 트리의 간선 수 공식임.
트리 판단 공식
조건: M == N - 1 (간선 수 = 노드 수 - 1) 그리고 cnt == 1 (단일 연결 요소).
결과:
두 조건 모두 참이면 "tree".
하나라도 거짓이면 "graph".
"""