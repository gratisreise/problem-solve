from itertools import permutations
from collections import deque

# 전처리
atk = [9, 3, 1]
atks = list(permutations(atk, 3))  # 공격 데미지 순열
vis, q = [[[0]*61 for _ in range(61)] for _ in range(61)], deque()  # 방문 배열, 큐
n = int(input())
a = [0]*3
for i, num in enumerate(map(int, input().split())):
    a[i] = num  # SCV 체력 입력

vis[a[0]][a[1]][a[2]] = 1  # 시작 상태 방문 (1부터 시작)
q.append(tuple(a))

# 탐색
while q:
    y, x, z = q.popleft()  # 현재 상태
    if vis[0][0][0]:  # 목표 상태 도달
        print(vis[0][0][0]-1)  # 공격 횟수 출력
        exit()
    for atk in atks:  # 6가지 공격 순열
        ny = max(0, y - atk[0])  # 체력 감소
        nx = max(0, x - atk[1])
        nz = max(0, z - atk[2])
        if vis[ny][nx][nz]:
            continue  # 방문済
        vis[ny][nx][nz] = vis[y][x][z] + 1  # 공격 횟수 기록
        q.append((ny, nx, nz))  # 다음 상태 추가

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 뮤탈리스크가 최대 3개의 SCV를 공격하여 모든 SCV의 체력을 0 이하로 만드는 최소 공격 횟수 구하기.
* 조건:
    * SCV 수: N (1 ≤ N ≤ 3).
    * SCV 체력: 1 ≤ 체력 ≤ 60.
    * 뮤탈리스크 공격: 한 번에 3개 타겟 공격, 데미지 (9, 3, 1).
    * 공격 순서: 3! = 6가지 (모든 순열 고려).
    * N < 3인 경우: 나머지 SCV 체력 0으로 처리.
* 출력: 최소 공격 횟수.
접근 아이디어
* BFS:
    * 상태: 각 SCV의 체력 (y, x, z).
    * 각 상태에서 6가지 공격 순열 적용, 새로운 상태 탐색.
    * 최단 경로(최소 횟수) → BFS 적합.
* 상태 관리:
    * a: SCV 체력 (최대 3개, 부족 시 0).
    * vis: 3차원 방문 배열 [y][x][z], 공격 횟수 저장.
    * q: BFS 큐, 현재 상태 (y, x, z).
    * atks: 공격 데미지 순열 (9, 3, 1의 모든 순열).
* 구현 전략:
    * 초기 상태에서 BFS 시작.
    * 각 상태에서 6가지 공격 적용, 새로운 상태 큐에 추가.
    * 체력 (0, 0, 0) 도달 시 공격 횟수 출력.
1. 입력 처리
* atk = [9, 3, 1]: 기본 공격 데미지.
* atks = list(permutations(atk, 3)): (9, 3, 1)의 모든 순열 (6가지).
* vis: 61×61×61 방문 배열 (체력 0~60).
* q = deque(): BFS 큐.
* n: SCV 수.
* a = [0]*3: SCV 체력 배열, 부족 시 0.
* for i, num in enumerate(...): 입력된 체력을 a에 저장.
2. BFS 초기화
* vis[a[0]][a[1]][a[2]] = 1: 초기 상태 방문 (공격 횟수 1부터).
* q.append(tuple(a)): 초기 상태 (y, x, z) 큐에 추가.
3. BFS 탐색
* while q:
    * y, x, z = q.popleft(): 현재 SCV 체력 상태.
    * if vis[0][0][0]: 목표 상태 (0, 0, 0) 도달:
        * print(vis[0][0][0]-1): 공격 횟수 출력 (1부터 시작했으므로 -1).
        * exit(): 종료.
    * for atk in atks: 6가지 공격 순열:
        * ny = max(0, y - atk[0]): 체력 감소 (음수 방지).
        * nx = max(0, x - atk[1]).
        * nz = max(0, z - atk[2]).
        * if vis[ny][nx][nz]: 방문済 → 스킵.
        * vis[ny][nx][nz] = vis[y][x][z] + 1: 공격 횟수 기록.
        * q.append((ny, nx, nz)): 다음 상태 추가.

문제 분석
* 문제: 백준 12869 "뮤탈리스크".
* 입력: N, N개의 SCV 체력.
* 출력: 최소 공격 횟수.
* 조건: (9, 3, 1) 데미지로 3개 타겟 공격, 순열 고려.

시간 복잡도
* 상태: (y, x, z) → O(61^3) ≈ 226,981.
* 각 상태에서 공격: 6가지 순열.
* BFS: O(61^3 * 6) ≈ 1.36×10^6.
* 실제: 체력 감소로 상태 수 훨씬 적음, 1초 내 충분.

"""