import sys

# 상어 이동 방향 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def move_sharks():
    global sharks, smell, grid
    new_grid = [[0] * n for _ in range(n)]
    for num in range(1, m + 1):
        if sharks[num] == None:
            continue
        x, y, dir = sharks[num]
        # 빈 칸 찾기
        found = False
        for i in range(4):
            ndir = priority[num][dir][i]
            nx = x + dx[ndir]
            ny = y + dy[ndir]
            if 0 <= nx < n and 0 <= ny < n and (isinstance(smell[nx][ny], int) or smell[nx][ny][1] == 0):
                found = True
                break
        # 빈 칸 못 찾으면 자신의 냄새가 있는 칸으로 이동
        if not found:
            for i in range(4):
                ndir = priority[num][dir][i]
                nx = x + dx[ndir]
                ny = y + dy[ndir]
                if 0 <= nx < n and 0 <= ny < n and isinstance(smell[nx][ny], list) and smell[nx][ny][0] == num:
                    break
        # 이동
        if new_grid[nx][ny] != 0:
            if new_grid[nx][ny] < num:
                sharks[num] = None
            else:
                sharks[new_grid[nx][ny]] = None
                new_grid[nx][ny] = num
                sharks[num] = (nx, ny, ndir)
        else:
            new_grid[nx][ny] = num
            sharks[num] = (nx, ny, ndir)
    grid = new_grid

def update_smell():
    global smell
    for i in range(n):
        for j in range(n):
            if isinstance(smell[i][j], list):
                smell[i][j][1] -= 1
                if smell[i][j][1] == 0:
                    smell[i][j] = 0
    for num in range(1, m + 1):
        if sharks[num] != None:
            x, y, _ = sharks[num]
            smell[x][y] = [num, k]

def check():
    for num in range(2, m + 1):
        if sharks[num] != None:
            return False
    return True

# 입력 처리
n, m, k = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
sharks = [None] * (m + 1)
for i in range(n):
    for j in range(n):
        if grid[i][j] != 0:
            sharks[grid[i][j]] = (i, j, 0)
initial_dir = list(map(int, sys.stdin.readline().split()))
for num in range(1, m + 1):
    x, y, _ = sharks[num]
    sharks[num] = (x, y, initial_dir[num - 1] - 1)
priority = [[[0] * 4 for _ in range(4)] for __ in range(m + 1)]
for num in range(1, m + 1):
    for dir in range(4):
        priority[num][dir] = list(map(lambda x: int(x) - 1, sys.stdin.readline().split()))
smell = [[0] * n for _ in range(n)]
for num in range(1, m + 1):
    if sharks[num] != None:
        x, y, _ = sharks[num]
        smell[x][y] = [num, k]

# 시뮬레이션 실행
time = 0
while time <= 1000:
    if check():
        break
    move_sharks()
    update_smell()
    time += 1

# 결과 출력
print(time if time <= 1000 else -1)
"""
문제 분석
문제: 백준 19237 "어른 상어".
    입력:
        n, m, k: 격자 크기(n×n), 상어 수(m), 냄새 지속 시간(k).
        n×n 격자: 초기 상어 위치 (0: 빈칸, 1~m: 상어 번호).
        상어 초기 방향: 1~4 (상, 하, 좌, 우).
        상어별 방향 우선순위: 각 상어(1m), 각 방향(03)에 대해 4개 우선순위.
    조건:
        상어 이동:
            모든 상어 동시에 이동.
            우선순위: 빈칸 → 자신의 냄새가 있는 칸 (주어진 우선순위 순).
            같은 칸 충돌: 번호 작은 상어만 남음.
    냄새:
        이동 후 현재 위치에 냄새 남김 (k초 유지).
        매 초 기존 냄새 1 감소, 0이면 사라짐.
    종료: 1번 상어만 남거나 1000초 초과.
출력: 1번 상어만 남는 시간, 1000초 초과 시 -1.

접근법
    시뮬레이션: 상어 이동과 냄새 업데이트를 초 단위로 진행.
    상태 관리:
        grid: 현재 상어 위치.
        sharks: 상어 정보 (위치, 방향).
        smell: 냄새 정보 (번호, 남은 시간).
    종료 조건: 2~m번 상어 모두 제거 확인.

1. 초기 설정
    sys: 빠른 입력을 위해 사용 (sys.stdin.readline).
    dx, dy: 상어 이동 4방향 (0: 상, 1: 하, 2: 좌, 3: 우).

2. 상어 이동 (move_sharks)
목적: 모든 상어를 새로운 위치로 이동.
동작:
    new_grid: 이동 후 상어 위치를 기록할 임시 격자.
    상어 순회: 1~m번 상어, 제거된 상어(None)는 건너뜀.
    빈칸 탐색:
        현재 방향 dir의 우선순위(priority[num][dir]) 순으로 이동 시도.
        조건: 경계 내, smell[nx][ny]가 int(0)거나 냄새 시간이 0.
        찾으면 found = True로 이동 확정.
    자신의 냄새:
        빈칸 없으면 같은 우선순위로 자신의 냄새(smell[nx][ny][0] == num) 탐색.
    이동 처리:
        이동 위치에 상어 있으면: 번호 작은 상어 남기고 큰 번호 제거.
        없으면: 새 위치에 배치, sharks 갱신.
    grid 갱신: 이동 완료 후 new_grid로 교체.
특징: isinstance로 smell의 타입(0 또는 리스트) 구분.

3. 냄새 업데이트 (update_smell)
목적: 기존 냄새 감소 및 새 냄새 추가.
동작:
    감소:
        smell[i][j]가 리스트면 시간([1]) 1 감소.
        0이면 int 0으로 변환.
    추가:
        남아있는 상어의 현재 위치에 [번호, k] 설정.
    특징: 냄새를 리스트와 정수로 구분 관리.

4. 종료 조건 체크 (check)
    목적: 1번 상어만 남았는지 확인.
    동작: 2~m번 상어가 하나라도 남아있으면 False, 모두 제거되면 True.

5. 입력 처리 및 초기화
    n, m, k: 격자 크기, 상어 수, 냄새 지속 시간.
    grid: 초기 상어 위치 입력.
    sharks: 상어 위치와 초기 방향 설정 (14 → 03).
    priority: 상어별 방향 우선순위 입력 (14 → 03).
    smell: 초기 상어 위치에 [번호, k] 설정.

6. 시뮬레이션 및 출력
목적: 시뮬레이션 실행 및 결과 출력.
동작:
    최대 1000초 반복, 종료 조건 충족 시 중단.
    순서: 상어 이동 → 냄새 업데이트 → 시간 증가.
    출력: 종료 시간, 1000초 초과 시 -1.

시간 복잡도
    상어 이동 (move_sharks): O(m × 4) (m마리, 4방향 탐색).
    냄새 업데이트 (update_smell): O(n^2 + m) (격자 전체 + 상어 수).
    종료 체크 (check): O(m).
    총 반복: 최대 1000초.
    총합: O(1000 × (m × 4 + n^2 + m)).
    최대값: n ≤ 20, m ≤ 400 → O(1000 × (1600 + 400 + 400)) ≈ O(2.4×10^6) → 1초 내 충분.

공간 복잡도
    grid: n × n × 4B ≈ 1600B (n=20).
    sharks: (m + 1) × 12B ≈ 4.8KB (m=400).
    smell: n × n × 8B ≈ 3.2KB (리스트 크기 고려).
    priority: m × 4 × 4 × 4B ≈ 25.6KB.
    총합: 약 35KB (512MB 내 여유).

"""