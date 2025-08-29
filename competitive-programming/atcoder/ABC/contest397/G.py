# Dinic 알고리즘을 사용한 최대 유량/최소 컷 계산 클래스
class Dinic:
    # 간선 정보를 저장하는 내부 클래스
    class Edge:
        def __init__(self, to, rev, c, oc):
            self.to = to    # 도착 노드 번호
            self.rev = rev  # 역방향 간선의 인덱스 (유량 갱신 시 사용)
            self.c = c      # 현재 잔여 용량
            self.oc = oc    # 원래 용량 (초기 값 저장)

    # Dinic 객체 초기화
    def __init__(self, n):
        self.lvl = [0] * n            # 각 노드의 BFS 레벨 (경로 깊이)
        self.ptr = [0] * n            # DFS에서 각 노드의 간선 탐색 위치
        self.q = [0] * n              # BFS에서 사용할 큐
        self.adj = [[] for _ in range(n)]  # 인접 리스트 (각 노드의 간선 저장)
        self.inf = 0                  # 최대 용량 기준 (DFS에서 유량 제한으로 사용)

    # 방향 간선 추가 메서드
    def addEdge(self, a, b, c, rc=0):
        # a -> b에 용량 c의 간선 추가
        self.adj[a].append(self.Edge(b, len(self.adj[b]), c, c))
        # b -> a에 용량 rc의 역방향 간선 추가 (기본값 0)
        self.adj[b].append(self.Edge(a, len(self.adj[a]) - 1, rc, rc))
        self.inf = max(self.inf, c, rc)  # 최대 용량 갱신

    # 증가 경로를 탐색하는 DFS 메서드
    def dfs(self, v, t, f):
        # v가 싱크(t)이거나 보낼 유량(f)이 0이면 종료
        if v == t or not f:
            return f
        # 현재 노드 v의 모든 간선을 탐색
        while self.ptr[v] < len(self.adj[v]):
            e = self.adj[v][self.ptr[v]]  # 현재 간선
            # 다음 노드의 레벨이 현재보다 1 크고, 잔여 용량이 있으면
            if self.lvl[e.to] == self.lvl[v] + 1:
                # 재귀적으로 증가 경로 탐색, 보낼 유량은 f와 잔여 용량 중 최소값
                p = self.dfs(e.to, t, min(f, e.c))
                if p:  # 유량을 보낼 수 있으면
                    self.adj[v][self.ptr[v]].c -= p    # 정방향 용량 감소
                    self.adj[e.to][e.rev].c += p       # 역방향 용량 증가
                    return p
            self.ptr[v] += 1  # 다음 간선으로 이동
        return 0  # 유량을 못 보내면 0 반환

    # 최대 유량을 계산하는 메서드 (최소 컷으로 사용됨)
    def calc(self, s, t):
        flow = 0  # 총 유량
        self.q[0] = s  # BFS 시작점 (소스)
        self.lvl[t] = 1  # 초기 조건 설정 (루프 진입용)
        # 싱크에 도달할 수 없을 때까지 반복
        while self.lvl[t]:
            self.lvl = [0] * len(self.q)  # 레벨 초기화
            self.ptr = [0] * len(self.q)  # 포인터 초기화
            qi = 0  # 큐 시작 인덱스
            qe = 1  # 큐 끝 인덱스
            self.lvl[s] = 1  # 소스 레벨 1로 설정
            # BFS로 레벨 그래프 생성
            while qi < qe and not self.lvl[t]:
                v = self.q[qi]
                qi += 1
                for e in self.adj[v]:
                    # 방문하지 않았고 잔여 용량이 있는 노드 탐색
                    if (not self.lvl[e.to]) and e.c:
                        self.q[qe] = e.to
                        self.lvl[e.to] = self.lvl[v] + 1
                        qe += 1
            p = 1  # 초기 유량 플래그
            # 증가 경로가 있을 때까지 DFS 반복
            while p:
                p = self.dfs(s, t, self.inf)  # 증가 경로로 유량 보내기
                flow += p  # 총 유량에 추가
        return flow  # 최소 컷 크기 반환

# 입력 처리
n, m, k = map(int, input().split())  # N: 정점 수, M: 간선 수, K: 선택 가능 간선 수
u = [0] * m  # 간선 시작 정점 리스트
v = [0] * m  # 간선 끝 정점 리스트
for i in range(m):
    u[i], v[i] = [int(j) - 1 for j in input().split()]  # 0-based로 변환

# 이진 탐색으로 최대 최단 거리 d 찾기
ans = 0  # 최종 답 (최대 d)
gap = 16  # 초기 탐색 간격 (N <= 30이므로 16으로 충분)
while gap:
    mid = ans | gap  # 현재 시도할 d 값 (비트 OR로 증가)
    flow = Dinic(n * mid)  # mid에 대한 Dinic 객체 생성 (노드 수: N * d)

    # 각 정점의 거리 단조성 보장 (y_{i,j} -> y_{i,j+1})
    for i in range(n):
        for j in range(mid - 1):
            # 정점 i의 거리 j에서 j+1로 가는 간선, 용량 105 (무한대 근사)
            flow.addEdge(i * mid + j, i * mid + j + 1, 105)

    # 원래 그래프의 간선에 대한 비용 설정
    for i in range(m):
        for j in range(mid):
            # 간선 (u[i], v[i])의 같은 거리 레벨 간선, 용량 1 (가중치 1 설정 시 비용)
            flow.addEdge(u[i] * mid + j, v[i] * mid + j, 1)
        for j in range(mid - 1):
            # 거리 증가 제한 조건, 용량 105 (최단 거리 최대 d 보장)
            flow.addEdge(u[i] * mid + j, v[i] * mid + j + 1, 105)

    # 소스(0)에서 싱크(n*mid-1)까지의 최소 컷 계산
    if flow.calc(0, n * mid - 1) <= k:
        ans = mid  # 최소 컷이 K 이하이면 d = mid 가능
    gap >>= 1  # 탐색 간격 절반으로 줄임

# 결과 출력
print(ans)  # 최대 가능한 최단 거리 d 출력