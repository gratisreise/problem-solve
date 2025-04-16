from collections import deque
n, m = map(int, input().split())  # 격자 크기
a, vis = [], []  # 격자, 방문 배열
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]  # 상, 우, 하, 좌

def dfs(i, j):
    stk = deque()
    vis[i][j] = 1
    stk.append((i, j))
    lis = []  # 녹을 치즈 좌표
    while stk:
        y, x = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:  # 범위 체크
                continue
            if vis[ny][nx]:  # 방문済
                continue
            if a[ny][nx] == 1:  # 치즈: 녹을 목록에 추가
                lis.append((ny, nx))
            else:  # 공기: 계속 탐색
                stk.append((ny, nx))
            vis[ny][nx] = 1  # 방문 표시
    return lis

# 격자 입력
for _ in range(n):
    a.append(list(map(int, input().split())))

ret = []  # 각 단계 녹은 치즈 수
while True:
    vis = [[0]*m for _ in range(n)]  # 방문 배열 초기화
    temp = dfs(0, 0)  # 외부 공기에서 DFS
    if not temp:  # 녹을 치즈 없음
        break
    ret.append(len(temp))  # 녹은 치즈 수 기록
    for i, j in temp:  # 치즈 녹임
        a[i][j] = 0

print(len(ret))  # 녹는 시간
print(ret[-1])  # 마지막 단계 치즈 수

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 치즈가 모두 녹는 데 걸리는 시간과 마지막 단계에서 녹은 치즈 조각 수 출력.
* 조건:
    * 격자: N×M (1 ≤ N, M ≤ 100).
    * 격자 값: 0(공기), 1(치즈).
    * 치즈는 공기와 접촉(상하좌우)하면 1시간 후 녹음.
    * 외부 공기는 (0,0)과 연결된 0.
* 출력:
    * 치즈가 모두 녹는 데 걸린 시간.
    * 마지막 단계에서 녹은 치즈 조각 수.
접근 아이디어
* DFS:
    * (0,0)에서 시작해 외부 공기(0)로 연결된 칸 탐색.
    * 치즈(1)에 도달하면 녹을 치즈로 기록 (계속 탐색 X).
* 시뮬레이션:
    * 각 단계에서:
        * DFS로 외부 공기 탐색, 녹을 치즈 목록 생성.
        * 치즈 목록이 비어 있으면 종료.
        * 치즈를 녹이고(0으로 변경) 단계 기록.
* 상태 관리:
    * a: 격자 상태.
    * vis: 방문 여부.
    * ret: 각 단계에서 녹은 치즈 수 리스트.
* 구현 전략:
    * DFS로 치즈 경계 탐색.
    * 녹은 치즈 수와 단계 수 추적.
1. 입력 처리
* n, m: 격자 세로(N), 가로(M).
* a: N×M 격자 입력 (0: 공기, 1: 치즈).
* dy, dx: 4방향 이동 벡터.
* vis: 방문 배열 (초기화는 루프 내).
2. DFS 함수
* dfs(i, j):
    * stk = deque(): 스택으로 DFS.
    * vis[i][j] = 1: 시작점 방문.
    * stk.append((i, j)): 시작점 추가.
    * lis: 녹을 치즈 좌표 리스트.
    * while stk:
        * y, x = stk.pop(): 현재 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 방문済: 스킵.
            * a[ny][nx] == 1: 치즈 → lis.append((ny, nx)).
            * a[ny][nx] == 0: 공기 → stk.append((ny, nx)).
            * vis[ny][nx] = 1: 방문 표시.
    * return lis: 녹을 치즈 목록 반환.
3. 시뮬레이션 루프
* ret: 각 단계 녹은 치즈 수 리스트.
* while True:
    * vis: 방문 배열 초기화.
    * temp = dfs(0, 0): (0,0)에서 외부 공기 탐색.
    * if not temp: 치즈 없음 → 종료.
    * ret.append(len(temp)): 녹은 치즈 수 기록.
    * for i, j in temp: 치즈 녹임 (a[i][j] = 0).
4. 출력
* len(ret): 녹는 시간 (단계 수).
* ret[-1]: 마지막 단계 녹은 치즈 수.

문제 분석
* 문제: 백준 2636 "치즈".
* 입력: N, M, N×M 격자.
* 출력: 녹는 시간, 마지막 단계 치즈 수.
* 조건: 치즈는 외부 공기와 접촉 시 녹음.

시간 복잡도
* DFS: O(N * M) (각 칸 최대 1번 방문).
* 최대 단계: 치즈 개수 (최악 N * M).
* 총합: O(N * M * T) (T는 단계 수, 최악 N * M ≈ 10^4), 1초 내 충분.

"""