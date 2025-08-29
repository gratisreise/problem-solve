import sys
ip, op = sys.stdin, sys.stdout  # 입출력 설정

def go(now, vis):
    vis[now], stk, cnt = 1, [], 0  # 방문 표시, 스택, 도달 노드 수
    stk.append(now)
    while stk:
        cnt += 1  # 현재 노드 카운트
        cur = stk.pop()  # 현재 노드
        if cur not in ret:  # 연결된 노드 없음
            continue
        for next in ret[cur]:  # 다음 노드 탐색
            if vis[next]:  # 방문済
                continue
            vis[next] = 1  # 방문 표시
            stk.append(next)  # 스택 추가
    return cnt

n, m = map(int, ip.readline().rstrip().split())  # 노드 수, 간선 수
vis, ret = [], {}  # 방문 배열, 역방향 그래프

# 그래프 구성
for _ in range(m):
    a, b = map(int, ip.readline().rstrip().split())  # A → B
    if b not in ret:
        ret[b] = []  # B 초기화
    ret[b].append(a)  # B → A 추가

mx, temp = -1, [0]*(n+1)  # 최대 도달 수, 노드별 도달 수

# 각 노드 DFS
for key in ret.keys():
    vis = [0] * (n+1)  # 방문 배열 초기화
    num = go(key, vis)  # 도달 노드 수
    mx = max(mx, num)  # 최대값 갱신
    temp[key] = num  # 도달 수 저장

# 최대 도달 수 가진 노드 수집
ret = []
for i, num in enumerate(temp):
    if num == mx:
        ret.append(str(i))

op.write(' '.join(ret)+'\n')  # 결과 출력
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 한 번의 해킹으로 가장 많은 컴퓨터를 해킹할 수 있는 노드 번호(들)를 오름차순으로 출력.
* 조건:
    * 노드 수: N (1 ≤ N ≤ 10,000).
    * 간선 수: M (1 ≤ M ≤ 100,000).
    * 간선: A → B (B를 해킹하면 A를 해킹 가능).
    * 여러 노드가 최대 해킹 수를 가질 수 있음.
* 출력: 최대 해킹 수를 가진 노드 번호들 (공백 구분).
접근 아이디어
* 그래프 표현:
    * 역방향 그래프: B → A (B에서 A로 도달 가능).
    * 각 노드에서 도달 가능한 노드 수를 계산.
* DFS:
    * 각 노드에서 DFS로 도달 가능한 노드 수 세기.
    * 방문 배열로 중복 방지.
* 최대값 처리:
    * 각 노드의 도달 노드 수 저장.
    * 최대값 찾고, 해당 값 가진 노드 수집.
* 구현 전략:
    * 인접 리스트로 그래프 구성.
    * 모든 노드에 대해 DFS 수행.
    * 최대 도달 노드 수와 해당 노드들 출력.
1. 입력 처리
* ip, op = sys.stdin, sys.stdout: 빠른 입출력.
* n, m: 노드 수(N), 간선 수(M).
* ret: 역방향 그래프 (딕셔너리, 키: 노드, 값: 연결된 노드 리스트).
* vis: 방문 배열 (루프 내 초기화).
2. 그래프 구성
* for _ in range(m):
    * a, b: 간선 A → B.
    * if b not in ret: B 초기화.
    * ret[b].append(a): B에서 A로 가는 간선 추가 (역방향).
3. DFS 함수
* go(now, vis):
    * vis[now] = 1: 현재 노드 방문.
    * stk, cnt = [], 0: 스택, 도달 노드 수.
    * stk.append(now): 시작 노드 추가.
    * while stk:
        * cnt += 1: 현재 노드 카운트.
        * cur = stk.pop(): 현재 노드.
        * if cur not in ret: 연결된 노드 없음 → 스킵.
        * for next in ret[cur]: 다음 노드 탐색:
            * vis[next]: 방문済 → 스킵.
            * vis[next] = 1: 방문 표시.
            * stk.append(next): 스택 추가.
    * return cnt: 도달 노드 수 반환.
4. 최대 도달 노드 계산
* mx, temp = -1, [0]*(n+1): 최대 도달 수, 노드별 도달 수 배열.
* for key in ret.keys():
    * vis = [0] * (n+1): 방문 배열 초기화.
    * num = go(key, vis): 도달 노드 수 계산.
    * mx = max(mx, num): 최대값 갱신.
    * temp[key] = num: 도달 수 저장.
5. 결과 처리 및 출력
* ret = []: 최대 도달 수 가진 노드 리스트.
* for i, num in enumerate(temp):
    * num == mx: 최대 도달 수면 노드 번호 추가.
* ' '.join(ret)+'\n': 노드 번호 공백 구분 출력.

문제 분석
* 문제: 백준 1325 "효율적인 해킹".
* 입력: N, M, M개의 간선(A → B).
* 출력: 최대 해킹 수 가진 노드 번호들 (오름차순).
* 조건: 한 노드 해킹 시 연결된 모든 노드 해킹 가능.

시간 복잡도
* 그래프 구성: O(M).
* DFS: O(N + M) (각 노드/간선 1번 방문).
* 노드 반복: O(N) (최악 모든 노드).
* 총합: O(N * (N + M)) ≈ 10^4 * 10^5 = 10^9 (최적화 필요 시 BFS/메모이제이션 고려, 본 코드로도 통과).
* 실제: M이 작아 통과 가능.
"""