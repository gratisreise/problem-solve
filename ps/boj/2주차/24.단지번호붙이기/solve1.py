from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌

def dfs(i, j):
    vis[i][j] = 1  # 시작점 방문
    stk = deque()
    stk.append((i, j))
    cnt = 0  # 단지 크기
    while stk:
        cnt += 1  # 현재 집 카운트
        y, x = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:  # 범위 체크
                continue
            if a[ny][nx] == 0 or vis[ny][nx] == 1:  # 빈 칸이거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가
    return cnt

n = int(input())  # 격자 크기
a, vis = [], [[0]*n for _ in range(n)]  # 격자, 방문 배열
for _ in range(n):
    a.append(list(map(int, input())))  # 격자 입력 (문자열 → 정수)

ret = []  # 각 단지 크기
for i in range(n):
    for j in range(n):
        if a[i][j] == 1 and vis[i][j] == 0:  # 집이고 미방문
            ret.append(dfs(i, j))  # 단지 크기 추가

ret.sort()  # 오름차순 정렬
print(len(ret), *ret, sep='\n')  # 단지 수, 각 단지 크기 출력


"""


문제 접근 방법과 아이디어
문제 이해
* 목표: 격자에서 연결된 집(단지)의 개수와 각 단지의 집 수를 오름차순으로 출력.
* 조건:
    * 격자: N×N (5 ≤ N ≤ 25).
    * 격자 값: 0(빈 칸), 1(집).
    * 연결: 상하좌우로 인접한 1.
* 출력:
    * 단지 수.
    * 각 단지의 집 수 (오름차순, 줄 단위).
접근 아이디어
* DFS:
    * 각 집(1)을 발견하면 DFS로 연결된 모든 1 탐색.
    * 탐색 중 1의 개수 세어 단지 크기 계산.
* 상태 관리:
    * a: 격자 상태.
    * vis: 방문 여부.
    * ret: 각 단지의 집 수 리스트.
* 구현 전략:
    * 격자 순회하며 미방문 1 발견 시 DFS 호출.
    * DFS로 단지 크기 계산, 리스트에 저장.
    * 결과 정렬 후 출력.
1. 입력 처리
* n: 격자 크기(N).
* dy, dx: 4방향 이동 벡터.
* a: N×N 격자, 입력 문자열을 정수 리스트로 변환 (예: "101" → [1, 0, 1]).
* vis: N×N 방문 배열, 초기값 0.
2. DFS 함수
* dfs(i, j):
    * vis[i][j] = 1: 시작점 방문.
    * stk = deque(): 스택으로 DFS.
    * stk.append((i, j)): 시작점 추가.
    * cnt: 단지 크기(집 수).
    * while stk:
        * cnt += 1: 현재 집 카운트.
        * y, x = stk.pop(): 현재 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 빈 칸(a[ny][nx] == 0) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
    * return cnt: 단지 크기 반환.
3. 단지 계산
* ret: 각 단지의 집 수 리스트.
* for i in range(n):
    * for j in range(n):
        * a[i][j] == 1 and vis[i][j] == 0: 집이고 미방문:
            * ret.append(dfs(i, j)): DFS로 단지 크기 계산 후 추가.
4. 출력
* ret.sort(): 단지 크기 오름차순 정렬.
* print(len(ret), *ret, sep='\n'): 단지 수와 각 단지 크기 출력.

문제 분석
* 문제: 백준 2667 "단지번호 붙이기".
* 입력: N, N×N 격자.
* 출력: 단지 수, 각 단지의 집 수 (오름차순).
* 조건: 1은 상하좌우로 연결, 단지는 연결된 1의 집합.

시간 복잡도
* 격자 순회: O(N^2).
* DFS: 각 칸 최대 1번 방문 → O(N^2).
* 정렬: O(K log K), K는 단지 수 (K ≤ N^2).
* 총합: O(N^2) (N ≤ 25, ≈ 625), 1초 내 충분.

"""