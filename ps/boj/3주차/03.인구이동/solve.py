import sys
from collections import deque
ip, op = sys.stdin.readline, sys.stdout.write  # 빠른 입출력
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]  # 상, 우, 하, 좌

def dfs(i, j, vis):
    ans = []  # 연합 칸들
    vis[i][j] = 1  # 시작점 방문
    q = deque()
    q.append((i, j))
    while q:
        y, x = q.pop()  # 현재 위치
        ans.append((y, x))  # 연합에 추가
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= n or vis[ny][nx]:
                continue
            if l <= abs(a[ny][nx] - a[y][x]) <= r:  # 연합 조건
                vis[ny][nx] = 1
                q.append((ny, nx))
    return ans

a = []
n, l, r = map(int, ip().split())  # 격자 크기, 인구 차이 범위
for _ in range(n):
    a.append(list(map(int, ip().split())))  # 격자 입력

move_count = 0  # 이동 횟수

while True:
    flag = False  # 이동 여부
    vis = [[0]*n for _ in range(n)]  # 방문 배열
    
    for i in range(n):
        for j in range(n):
            if vis[i][j]:
                continue  # 이미 방문
            temp = dfs(i, j, vis)  # 연합 탐색
            if len(temp) == 1:
                continue  # 연합 없음
            sum_p = sum(a[y][x] for y, x in temp)  # 연합 인구 합
            for y, x in temp:
                a[y][x] = sum_p // len(temp)  # 평균으로 갱신
            flag = True  # 이동 발생
    if not flag:
        break  # 이동 없음
    move_count += 1

print(move_count)  # 결과 출력


"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 인구 이동이 더 이상 발생하지 않을 때까지의 이동 횟수(일 수) 구하기.
* 조건:
    * 격자: N×N (1 ≤ N ≤ 50).
    * 격자 값: 각 칸의 인구 수 (0 ≤ A[i][j] ≤ 100).
    * 인구 이동 조건:
        * 인접한 두 칸의 인구 차이가 L 이상 R 이하 (L ≤ |A[ny][nx] - A[y][x]| ≤ R).
        * 국경이 열리면 연합 형성.
    * 연합 내 인구: 연합 인구 합 / 연합 칸 수 (소수점 버림).
    * 이동은 하루에 한 번, 모든 칸 동시에 발생.
    * 이동이 없으면 종료.
* 출력: 인구 이동 횟수 (일 수).
접근 아이디어
* DFS:
    * 각 칸에서 DFS를 사용하여 연합(국경이 열린 칸들)을 탐색.
    * 연합 조건: 인접 칸의 인구 차이가 L ≤ |A[ny][nx] - A[y][x]| ≤ R.
* 시뮬레이션:
    * 매일:
        * 모든 칸을 순회하며 미방문 칸에서 DFS로 연합 형성.
        * 연합 크기 ≥ 2면 인구 평균으로 갱신.
        * 이동 발생 여부 플래그로 확인.
    * 이동 없으면 종료.
* 상태 관리:
    * a: 격자(인구 수).
    * vis: 방문 배열.
    * move_count: 이동 횟수.
    * flag: 이동 발생 여부.
* 구현 전략:
    * DFS로 연합 탐색 → 인구 갱신 → 반복.
    * 이동 없으면 횟수 출력.
1. 입력 처리
* ip, op = sys.stdin.readline, sys.stdout.write: 빠른 입출력.
* n, l, r: 격자 크기(N), 인구 차이 범위(L, R).
* dy, dx: 4방향 이동 벡터 (상, 우, 하, 좌).
* a: N×N 격자 입력 (인구 수).
* move_count = 0: 이동 횟수 초기화.
2. DFS 함수
* dfs(i, j, vis):
    * ans: 연합 칸 좌표 리스트.
    * vis[i][j] = 1: 시작점 방문.
    * q = deque(): DFS 큐 (스택 대신 큐 사용, 결과 동일).
    * q.append((i, j)): 시작점 추가.
    * while q:
        * y, x = q.pop(): 현재 위치 (DFS로 스택처럼 동작).
        * ans.append((y, x)): 연합에 추가.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남 또는 방문済: 스킵.
            * 연합 조건: l <= abs(a[ny][nx] - a[y][x]) <= r.
            * 조건 만족 시:
                * vis[ny][nx] = 1: 방문 표시.
                * q.append((ny, nx)): 다음 위치 추가.
    * return ans: 연합 칸들 반환.
3. 시뮬레이션 루프
* while True:
    * flag = False: 이동 여부 플래그.
    * vis = [[0]*n for _ in range(n)]: 방문 배열 초기화.
    * for i in range(n):
        * for j in range(n):
            * vis[i][j]: 방문済 → 스킵.
            * temp = dfs(i, j, vis): 연합 탐색.
            * len(temp) == 1: 연합 없음 → 스킵.
            * sum_p = sum(a[y][x] for y, x in temp): 연합 인구 합.
            * for y, x in temp: 각 칸을 sum_p // len(temp)로 갱신.
            * flag = True: 이동 발생.
    * if not flag: 이동 없음 → 종료.
    * move_count += 1: 이동 횟수 증가.
4. 출력
* print(move_count): 총 이동 횟수 출력.

문제 분석
* 문제: 백준 16234 "인구 이동".
* 입력: N, L, R, N×N 격자.
* 출력: 인구 이동 횟수.
* 조건: 인구 차이 L~R인 인접 칸 연합, 평균 인구로 갱신.

시간 복잡도
* DFS: O(N^2) (각 칸 최대 1번 방문).
* 격자 순회: O(N^2).
* 최대 반복: 인구 값 변화에 따라 (최악 수렴까지, 실제로는 작음).
* 총합: O(N^2 * T) (N ≤ 50, T는 반복 수, 약 10^6 이하), 1초 내 충분.
"""