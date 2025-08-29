from collections import deque
n = int(input())
a, vis = [], []

dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]  # 상, 우, 하, 좌

# DFS 함수 (스택으로 구현)
def dfs(i, j, h):
    stk = deque()
    vis[i][j] = 1  # 시작점 방문
    stk.append((i, j))
    while stk:
        y, x = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:  # 범위 체크
                continue
            if a[ny][nx] <= h or vis[ny][nx]:  # 잠기거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가

# 격자 입력
for _ in range(n):
    a.append(list(map(int, input().split())))

# 최대 안전 영역 계산
ret = -1
for h in range(101):  # 높이 0~100까지
    vis = [[0]*n for _ in range(n)]  # 방문 배열 초기화
    cnt = 0  # 안전 영역 수
    for i in range(n):
        for j in range(n):
            if a[i][j] <= h or vis[i][j]:  # 잠기거나 방문済
                continue
            dfs(i, j, h)  # 안전 영역 탐색
            cnt += 1
    ret = max(cnt, ret)  # 최대값 갱신

# 출력
print(ret)


"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 비가 내린 후 안전 영역(잠기지 않은 연결된 구역)의 최대 개수 구하기.
* 조건:
    * 격자: N×N (2 ≤ N ≤ 100).
    * 각 칸의 높이: 1 이상 100 이하.
    * 비의 양(h)에 따라 h 이하 높이의 칸은 잠김.
    * 이동: 상하좌우 4방향.
* 출력: 가능한 최대 안전 영역 수.
접근 아이디어
* DFS 선택:
    * 연결된 안전 영역을 하나의 구역으로 묶기 위해 DFS 사용 (BFS도 가능).
* 상태 정의:
    * a[y][x]: 각 칸의 높이.
    * vis[y][x]: 방문 여부.
* 탐색:
    * 각 높이 h에 대해, h 초과인 칸들 중 방문하지 않은 곳에서 DFS로 연결된 영역 탐색.
    * h마다 안전 영역 수 계산, 최대값 갱신.
* 구현 전략:
    * 높이 0~100까지 반복 (최대 100).
    * 각 h에서 DFS로 안전 영역 수 세기.
    * 스택 기반 DFS로 효율적 구현.

    1. 입력 처리
* n: 격자 크기(N).
* dy, dx: 4방향 이동 벡터 (상, 우, 하, 좌).
* a: N×N 격자, 높이 입력.
2. DFS 함수
* i, j: 시작 위치.
* h: 현재 비의 양 (잠기는 기준).
* 동작:
    * stk = deque(): 스택으로 DFS 구현.
    * vis[i][j] = 1: 시작점 방문.
    * stk.append((i, j)): 시작점 추가.
    * while stk: 스택이 빌 때까지:
        * y, x = stk.pop(): 현재 위치 꺼냄 (LIFO).
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 잠김(a[ny][nx] <= h) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
3. 메인 로직
* ret = -1: 최대 안전 영역 수 (초기값).
* for h in range(101): 비의 양 0~100까지 반복.
    * vis: N×N 방문 배열, 각 h마다 초기화.
    * cnt: 현재 h에서의 안전 영역 수.
    * 격자 순회:
        * a[i][j] <= h || vis[i][j]: 잠기거나 방문済 → 스킵.
        * DFS 호출: 안전 영역 탐색, cnt 증가.
    * ret = max(cnt, ret): 최대값 갱신.
* 출력: ret 출력.

문제 분석
* 문제: 백준 2468 "안전 영역".
* 입력: N, N×N 격자 높이.
* 출력: 최대 안전 영역 수.
* 조건: 4방향 이동, h 이하 잠김.

시간 복잡도
* DFS: 각 칸 최대 1번 방문 → O(N * N).
* 격자 순회: O(N * N).
* 높이 반복: O(101).
* 총합: O(101 * N * N) (N ≤ 100, ≈ 10^6), 1초 내 충분.

결론
* 정확성: DFS로 연결된 안전 영역 정확히 계산, 모든 h 고려.
* 효율성: 시간 O(101 * N * N), 공간 O(N * N).
* 아이디어: 높이별 DFS로 안전 영역 수 세고 최대값 갱신.

"""