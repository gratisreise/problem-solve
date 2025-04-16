n, m = map(int, input().split())  # 격자 크기
a, vis = [], []  # 격자, 방문 배열
empty, vir = [], []  # 빈 칸, 바이러스 좌표
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]  # 상, 우, 하, 좌

def dfs(y, x, vis):
    stk = []
    vis[y][x] = 1
    stk.append((y, x))
    while stk:
        cy, cx = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = cy + dy[d], cx + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:  # 범위 체크
                continue
            if a[ny][nx] == 1 or vis[ny][nx]:  # 벽이거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가

def go():
    vis = [[0]*m for _ in range(n)]  # 방문 배열 초기화
    for i, j in vir:  # 모든 바이러스에서 DFS
        dfs(i, j, vis)
    cnt = 0  # 안전 영역 수
    for i in range(n):
        for j in range(m):
            if a[i][j] == 0 and vis[i][j] == 0:  # 빈 칸이고 바이러스 미도달
                cnt += 1
    return cnt

# 격자 입력 및 빈 칸/바이러스 좌표 저장
for i in range(n):
    a.append(list(map(int, input().split())))
    for j in range(m):
        if a[i][j] == 2:
            vir.append((i, j))  # 바이러스
        elif a[i][j] == 0:
            empty.append((i, j))  # 빈 칸

size = len(empty)  # 빈 칸 개수
ret = -1  # 최대 안전 영역
for i in range(size):
    for j in range(i+1, size):
        for k in range(j+1, size):  # 빈 칸 3개 조합
            a[empty[i][0]][empty[i][1]] = 1  # 벽 설치
            a[empty[j][0]][empty[j][1]] = 1
            a[empty[k][0]][empty[k][1]] = 1
            ret = max(ret, go())  # 안전 영역 계산
            a[empty[i][0]][empty[i][1]] = 0  # 벽 제거
            a[empty[j][0]][empty[j][1]] = 0
            a[empty[k][0]][empty[k][1]] = 0

print(ret)  # 결과 출력


"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 벽 3개를 설치해 바이러스가 퍼지지 않는 안전 영역(0)의 최대 개수 구하기.
* 조건:
    * 격자: N×M (3 ≤ N, M ≤ 8).
    * 격자 값: 0(빈 칸), 1(벽), 2(바이러스).
    * 벽 3개 추가 설치 가능.
    * 바이러스는 상하좌우로 퍼짐 (0으로 이동).
* 출력: 안전 영역의 최대 크기.
접근 아이디어
* 브루트 포스:
    * 빈 칸(0) 중 3개를 골라 벽(1)으로 설정.
    * 모든 조합 시도 (최대 8×8=64칸 → 조합 수 적음).
* DFS:
    * 바이러스 위치에서 DFS로 퍼뜨림.
    * 방문하지 않은 빈 칸(0)을 안전 영역으로 카운트.
* 상태 관리:
    * a: 격자 상태.
    * vis: 바이러스 방문 여부.
    * empty: 빈 칸 좌표 리스트.
    * vir: 바이러스 좌표 리스트.
* 구현 전략:
    * 빈 칸 조합 생성.
    * 각 조합마다 벽 설치 → DFS로 바이러스 퍼뜨림 → 안전 영역 계산.
    * 최대 안전 영역 갱신.
1. 입력 처리
* n, m: 격자 세로(N), 가로(M).
* a: N×M 격자.
* empty, vir: 빈 칸(0)과 바이러스(2) 좌표 리스트.
* dy, dx: 4방향 이동 벡터.
* 격자 입력하며 a[i][j] 확인:
    * a[i][j] == 2: vir에 추가.
    * a[i][j] == 0: empty에 추가.
2. DFS 함수
* dfs(y, x, vis):
    * stk: 스택으로 DFS 구현.
    * vis[y][x] = 1: 시작점 방문.
    * stk.append((y, x)): 시작점 추가.
    * while stk:
        * cy, cx = stk.pop(): 현재 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 벽(a[ny][nx] == 1) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
3. 안전 영역 계산 함수
* go():
    * vis: 방문 배열 초기화.
    * for i, j in vir: 각 바이러스 위치에서 DFS 호출.
    * cnt: 안전 영역 수.
    * 격자 순회:
        * a[i][j] == 0 and vis[i][j] == 0: 바이러스가 퍼지지 않은 빈 칸 → cnt += 1.
    * return cnt: 안전 영역 크기 반환.
4. 벽 조합 및 결과 계산
* size = len(empty): 빈 칸 개수.
* ret = -1: 최대 안전 영역 초기값.
* 3중 루프:
    * i, j, k: 빈 칸 조합 선택.
    * a[empty[i][0]][empty[i][1]] = 1: 벽 설치.
    * ret = max(ret, go()): 안전 영역 계산 후 최대값 갱신.
    * a[...][...] = 0: 벽 제거.
5. 출력
* print(ret): 최대 안전 영역 크기 출력.

문제 분석
* 문제: 백준 14502 "연구소".
* 입력: N, M, N×M 격자.
* 출력: 안전 영역 최대 크기.
* 조건: 벽 3개 설치, 바이러스 상하좌우 퍼짐.

시간 복잡도
* 빈 칸 조합: C(size, 3) ≤ C(64, 3) ≈ 41,664.
* DFS: O(N * M) (최대 8×8=64).
* 안전 영역 계산: O(N * M).
* 총합: O(C(size, 3) * N * M) ≈ 41,664 * 64 ≈ 2.7×10^6, 1초 내 충분.
"""