from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌
m, n, k = map(int, input().split())  # 세로, 가로, 직사각형 수
a, vis = [[0]*n for _ in range(m)], [[0]*n for _ in range(m)]  # 격자, 방문 배열

# DFS 함수 (스택으로 구현)
def dfs(i, j):
    stk = deque()
    stk.append((i, j))    
    vis[i][j] = 1  # 시작점 방문
    ans = 0  # 영역 넓이
    while stk:
        ans += 1  # 방문한 칸 수 증가
        y, x = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= m or nx >= n:  # 범위 체크
                continue
            if a[ny][nx] or vis[ny][nx]:  # 직사각형이거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가
    return ans  # 영역 넓이 반환

# 직사각형 입력 및 격자 채우기
for _ in range(k):
    a1, b1, a2, b2 = map(int, input().split())  # 좌하(x1,y1), 우상(x2,y2)
    for i in range(b1, b2):  # y축 범위
        for j in range(a1, a2):  # x축 범위
            a[i][j] = 1  # 직사각형 표시

# 영역 탐색
cnt, ret = 0, []  # 영역 수, 넓이 리스트
for i in range(m):
    for j in range(n):
        if a[i][j] or vis[i][j]:  # 직사각형이거나 방문済
            continue
        cnt += 1  # 새로운 영역 발견
        ret.append(dfs(i, j))  # 영역 넓이 추가

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 직사각형으로 채워지지 않은 영역의 개수와 각 영역의 넓이(오름차순) 구하기.
* 조건:
    * 격자: M×N (1 ≤ M, N ≤ 100).
    * 직사각형 개수: K (0 ≤ K ≤ 100).
    * 직사각형 좌표: (x1,y1) ~ (x2,y2) (왼쪽 아래 ~ 오른쪽 위).
    * 이동: 상하좌우 4방향.
* 출력: 영역 수, 각 영역 넓이 (공백 구분, 오름차순).
접근 아이디어
* DFS 선택:
    * 연결된 빈 칸을 하나의 영역으로 묶기 위해 DFS 사용 (BFS도 가능).
* 상태 정의:
    * a[y][x]: 격자 상태 (0: 빈 칸, 1: 직사각형).
    * vis[y][x]: 방문 여부.
* 탐색:
    * 빈 칸(0)이고 방문하지 않은 곳에서 DFS로 연결된 모든 칸 방문, 넓이 계산.
    * 영역 개수와 각 영역 넓이 리스트에 저장.
* 구현 전략:
    * 직사각형으로 채워진 격자 초기화.
    * DFS로 영역 탐색, 넓이 반환.
    * 결과 정렬 후 출력.

1. 입력 처리
* m, n, k: 세로(M), 가로(N), 직사각형 수(K).
* dy, dx: 4방향 이동 벡터 (상, 우, 하, 좌).
* a: M×N 격자, 0으로 초기화.
* vis: M×N 방문 배열, 0으로 초기화.
2. DFS 함수
* i, j: 시작 위치.
* 동작:
    * stk = deque(): 스택으로 DFS 구현.
    * vis[i][j] = 1: 시작점 방문.
    * stk.append((i, j)): 시작점 추가.
    * ans: 영역 넓이.
    * while stk: 스택이 빌 때까지:
        * ans += 1: 현재 칸 카운트.
        * y, x = stk.pop(): 현재 위치 꺼냄 (LIFO).
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 직사각형(a[ny][nx] == 1) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
    * return ans: 영역 넓이 반환.
3. 직사각형 입력 및 채우기
* K번 반복:
    * a1, b1, a2, b2: 직사각형 좌표 (x1, y1, x2, y2).
    * for i in range(b1, b2): y축 범위.
    * for j in range(a1, a2): x축 범위.
    * a[i][j] = 1: 직사각형 영역 표시.
4. 영역 계산
* cnt: 영역 수.
* ret: 각 영역 넓이 리스트.
* 격자 순회:
    * a[i][j] == 1 || vis[i][j]: 직사각형이거나 방문済 → 스킵.
    * cnt += 1: 새로운 영역 발견.
    * ret.append(dfs(i, j)): DFS로 넓이 계산 후 리스트에 추가.
5. 출력
* print(cnt): 영역 수 출력.
* print(' '.join(map(str, sorted(ret)))): 넓이 리스트를 정렬 후 공백 구분 출력.

문제 분석
* 문제: 백준 2583 "영역 구하기".
* 입력: M, N, K, K개의 직사각형 좌표.
* 출력: 영역 수, 각 영역 넓이 (오름차순).
* 조건: 4방향 이동, 직사각형 외부 영역 계산.

시간 복잡도
* DFS: 각 칸 최대 1번 방문 → O(M * N).
* 격자 순회: O(M * N).
* 직사각형 채우기: O(K * M * N) (최악).
* 총합: O(M * N + K * M * N) (M, N ≤ 100, K ≤ 100, ≈ 10^6), 1초 내 충분.


결론
* 정확성: DFS로 연결된 빈 영역 정확히 계산, 넓이 오름차순 출력.
* 효율성: 시간 O(M * N + K * M * N), 공간 O(M * N).
* 아이디어: 스택 기반 DFS로 영역 탐색, 직사각형 외부 구역 분리.

"""