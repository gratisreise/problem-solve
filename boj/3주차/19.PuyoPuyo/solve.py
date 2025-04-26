from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌

# 격자 입력
a = []
for i in range(12):
    a.append(list(input()))

ret = 0  # 연쇄 횟수
while True:   
    boom = False  # 터짐 여부
    vis = [[0]*6 for _ in range(12)]  # 방문 배열
    for i in range(12):
        for j in range(6):
            if a[i][j] == '.' or vis[i][j]: 
                continue
            stk, temp, vis[i][j] = deque(), [(i,j)], 1  # BFS 큐, 그룹 좌표, 방문 표시
            stk.append((i,j))
            while stk:
                y, x = stk.pop()
                for d in range(4):
                    ny, nx = y + dy[d], x + dx[d]
                    if not(0 <= ny < 12 and 0 <= nx < 6):
                        continue
                    if a[ny][nx] == '.' or a[ny][nx] != a[y][x] or vis[ny][nx]:
                        continue
                    vis[ny][nx] = 1
                    stk.append((ny, nx))
                    temp.append((ny, nx))
            if len(temp) < 4:  # 그룹 크기 4 미만
                for i, j in temp:
                    vis[i][j] = 0  # 방문 해제
                continue
            for i, j in temp:  # 터뜨리기
                a[i][j] = '.'
            boom = True
    if not boom: break  # 터짐 없음 → 종료
    ret += 1  # 연쇄 횟수 증가
    # 중력 적용
    for j in range(6):
        for i in range(11, -1, -1):
            if a[i][j] == '.':
                temp = i
                while temp > 0 and a[temp][j] == '.':
                    temp -= 1
                if a[temp][j] != '.':
                    a[i][j], a[temp][j] = a[temp][j], a[i][j]
print(ret)

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 뿌요를 터뜨리고 떨어뜨리는 연쇄 횟수 구하기.
* 조건:
    * 격자: 12×6 (고정).
    * 격자 값:
        * 'R', 'G', 'B', 'P', 'Y': 뿌요 색상.
        * '.': 빈 칸.
    * 뿌요 터짐:
        * 같은 색 뿌요가 상하좌우로 4개 이상 연결 시 터짐.
        * 터진 뿌요는 '.'로 변경.
    * 중력:
        * 터짐 후 빈 칸 아래로 뿌요 이동.
    * 연쇄:
        * 터짐 → 중력 → 터짐 반복.
        * 더 이상 터질 뿌요 없으면 종료.
* 출력: 연쇄 횟수.
접근 아이디어
* BFS:
    * 각 뿌요에서 같은 색 연결 그룹 탐색.
    * 그룹 크기가 4 이상이면 터뜨림 ('.'로 변경).
* 연쇄 처리:
    * 한 번의 터짐 여부 확인 (boom).
    * 터짐 후 중력 적용 (뿌요 아래로 이동).
    * 터짐 없으면 종료.
* 상태 관리:
    * a: 격자 상태.
    * vis: 방문 배열 (BFS용).
    * ret: 연쇄 횟수.
* 구현 전략:
    * 격자 전체 순회하며 뿌요 그룹 BFS.
    * 4개 이상 그룹 터뜨림, 연쇄 횟수 증가.
    * 중력 적용 후 반복, 터짐 없으면 종료.
1. 입력 처리
* a: 12×6 격자 입력 (문자 리스트: 'R', 'G', 'B', 'P', 'Y', '.').
* dy, dx: 4방향 이동 벡터 (상, 우, 하, 좌).
* ret = 0: 연쇄 횟수 초기화.
2. 연쇄 루프
* while True:
    * boom = False: 터짐 여부 초기화.
    * vis = [[0]*6 for _ in range(12)]: 방문 배열 초기화.
    * BFS로 뿌요 그룹 탐색:
        * for i in range(12):
            * for j in range(6):
                * a[i][j] == '.' or vis[i][j]: 빈 칸 또는 방문済 → 스킵.
                * BFS 초기화:
                    * stk = deque(): BFS 큐.
                    * temp = [(i,j)]: 그룹 좌표 저장.
                    * vis[i][j] = 1: 방문 표시.
                    * stk.append((i,j)).
                * BFS:
                    * y, x = stk.pop(): 현재 위치.
                    * 4방향 탐색:
                        * ny, nx: 다음 위치.
                        * 범위 내, 같은 색(a[ny][nx] == a[y][x]), 미방문:
                            * vis[ny][nx] = 1.
                            * stk.append((ny, nx)).
                            * temp.append((ny, nx)).
                * 그룹 처리:
                    * len(temp) < 4: 그룹 크기 4 미만 → 방문 해제 (vis[i][j] = 0).
                    * 4 이상: a[i][j] = '.'로 터뜨림, boom = True.
    * if not boom: 터짐 없음 → 루프 종료.
    * ret += 1: 연쇄 횟수 증가.
3. 중력 적용
* for j in range(6): 각 열.
    * for i in range(11, -1, -1): 아래에서 위로 (중력 방향).
        * a[i][j] == '.': 빈 칸 발견.
        * temp = i: 현재 위치.
        * while temp > 0 and a[temp][j] == '.': 위로 이동하며 빈 칸 확인.
        * if a[temp][j] != '.': 뿌요 발견 → a[i][j]와 교환.
4. 출력
* print(ret): 연쇄 횟수 출력.

문제 분석
* 문제: 백준 11559 "Puyo Puyo".
* 입력: 12×6 격자.
* 출력: 연쇄 횟수.
* 조건: 4개 이상 연결 뿌요 터짐, 중력 적용.

시간 복잡도
* 격자: 12×6 = 72.
* BFS: 각 칸에서 O(72) (최악 모든 칸 방문).
* 최악 연쇄: O(72) (모든 뿌요가 단계적으로 터짐).
* 총합: O(72 * 72 * 연쇄) ≈ O(5184 * 연쇄), 연쇄 수 제한적 (1초 내 통과).
"""