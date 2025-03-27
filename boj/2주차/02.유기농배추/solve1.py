from collections import deque
t = int(input())

dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]  # 상, 우, 하, 좌

# DFS 함수 (스택으로 구현)
def dfs(y, x, vis, a):
    stk = deque()
    vis[y][x] = 1  # 시작점 방문
    stk.append((y, x))
    while stk:
        cy, cx = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = cy + dy[d], cx + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:  # 범위 체크
                continue
            if a[ny][nx] == 0 or vis[ny][nx]:  # 배추 없거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가

# 메인 로직
for _ in range(t):
    m, n, k = map(int, input().split())  # 가로, 세로, 배추 수
    a = [[0]*m for _ in range(n)]  # 격자
    vis = [[0]*m for _ in range(n)]  # 방문 배열
    
    # 배추 위치 입력
    for _ in range(k):
        x, y = map(int, input().split())
        a[y][x] = 1  # 배추 표시
    
    # 군집 수 계산
    cnt = 0
    for i in range(n):
        for j in range(m):
            if a[i][j] and vis[i][j] == 0:  # 배추 있고 미방문
                dfs(i, j, vis, a)
                cnt += 1
    print(cnt)

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 배추 군집(연결된 배추 그룹)의 개수 구하기.
* 조건:
    * 테스트 케이스: T개.
    * 격자: M×N (1 ≤ M, N ≤ 50).
    * 배추 위치: K개 (0 ≤ K ≤ 2500).
    * 이동: 상하좌우 4방향.
* 출력: 각 테스트 케이스별 배추흰지렁이 수 (군집 수).
접근 아이디어
* DFS 선택:
    * 연결된 배추를 하나의 군집으로 묶기 위해 DFS 사용 (BFS도 가능).
* 상태 정의:
    * a[y][x]: 배추 위치 (1: 배추, 0: 없음).
    * vis[y][x]: 방문 여부.
* 탐색:
    * 배추가 있고 방문하지 않은 칸 발견 시 DFS로 연결된 모든 배추 방문.
    * 군집 하나당 카운트 1 증가.
* 구현 전략:
    * deque로 스택 구현 (DFS를 스택으로 iterative하게).
    * 각 테스트 케이스별로 격자와 방문 배열 초기화.

1. 입력 처리
* t: 테스트 케이스 수.
* dy, dx: 4방향 이동 벡터 (상, 우, 하, 좌).
2. DFS 함수
* y, x: 시작 위치.
* vis: 방문 배열.
* a: 격자.
* 동작:
    * stk = deque(): 스택으로 DFS 구현.
    * vis[y][x] = 1: 시작점 방문.
    * stk.append((y, x)): 시작점 추가.
    * while stk: 스택이 빌 때까지:
        * cy, cx = stk.pop(): 현재 위치 꺼냄 (LIFO).
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 배추 없음(a[ny][nx] == 0) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
3. 메인 로직
* 테스트 케이스 반복:
    * m, n, k: 가로(M), 세로(N), 배추 수(K).
    * a: N×M 격자, 0으로 초기화.
    * vis: N×M 방문 배열, 0으로 초기화.
* 배추 입력:
    * K번 반복, (x,y)에 배추 표시 (a[y][x] = 1).
* 군집 계산:
    * cnt: 군집 수.
    * 격자 순회:
        * a[i][j] == 1 && vis[i][j] == 0: 배추 있고 미방문 → DFS 호출, cnt 증가.
* 출력: cnt 출력.
문제 분석
* 문제: 백준 1012 "유기농 배추".
* 입력: T, 각 T별 M, N, K, K개의 (x,y).
* 출력: 각 테스트 케이스별 군집 수.
* 조건: 4방향 이동, 연결된 배추는 한 군집.

시간 복잡도
* DFS: 각 칸 최대 1번 방문 → O(N * M).
* 격자 순회: O(N * M).
* 총합: O(T * N * M) (T ≤ 50, N, M ≤ 50, ≈ 10^5), 1초 내 충분.

결론
* 정확성: DFS로 연결된 배추 군집 정확히 계산.
* 효율성: 시간 O(T * N * M), 공간 O(N * M).
* 아이디어: 스택 기반 DFS로 군집 탐색, 방문 배열로 중복 방지.
"""