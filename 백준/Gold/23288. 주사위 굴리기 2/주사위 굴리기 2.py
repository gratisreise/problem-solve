from collections import deque

# 입력 처리
n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 주사위 초기 상태
dice = [2, 4, 1, 3, 5, 6]  # [뒷면, 왼쪽면, 윗면, 오른쪽면, 앞면, 아랫면]

# 방향 벡터 (동, 남, 서, 북)
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# 주사위 굴리기 함수
def roll_dice(dice, direction):
    if direction == 0:  # 동쪽
        dice[1], dice[2], dice[3], dice[5] = dice[5], dice[1], dice[2], dice[3]
    elif direction == 1:  # 남쪽
        dice[0], dice[2], dice[4], dice[5] = dice[5], dice[0], dice[2], dice[4]
    elif direction == 2:  # 서쪽
        dice[1], dice[2], dice[3], dice[5] = dice[2], dice[3], dice[5], dice[1]
    elif direction == 3:  # 북쪽
        dice[0], dice[2], dice[4], dice[5] = dice[2], dice[4], dice[5], dice[0]
    return dice

# BFS로 점수 계산
def calculate_score(x, y):
    visited = [[False] * m for _ in range(n)]
    queue = deque([(x, y)])
    visited[x][y] = True
    value = grid[x][y]
    count = 1

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and grid[nx][ny] == value:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    count += 1
    return value * count

# 주사위 이동 및 점수 계산
x, y = 0, 0  # 주사위 초기 위치
direction = 0  # 초기 방향: 동쪽
total_score = 0

for _ in range(k):
    # 주사위 이동
    nx, ny = x + dx[direction], y + dy[direction]
    if not (0 <= nx < n and 0 <= ny < m):  # 이동 불가능한 경우 방향 반전
        direction = (direction + 2) % 4
        nx, ny = x + dx[direction], y + dy[direction]
    x, y = nx, ny

    # 주사위 굴리기
    dice = roll_dice(dice, direction)

    # 점수 계산
    total_score += calculate_score(x, y)

    # 다음 방향 결정
    if dice[5] > grid[x][y]:  # 주사위 아랫면 > 현재 칸의 값: 시계 방향
        direction = (direction + 1) % 4
    elif dice[5] < grid[x][y]:  # 주사위 아랫면 < 현재 칸의 값: 반시계 방향
        direction = (direction - 1) % 4

# 결과 출력
print(total_score)

"""
코드 설명
1. 입력 처리
    입력:
        n, m, k: 격자 크기(N×M), 이동 횟수(K).
            1 ≤ N, M ≤ 20, 1 ≤ K ≤ 1,000.
        grid: N×M 격자, 각 칸의 값은 1 이상 10 이하.
        예: grid = [[1, 2, 3], [4, 5, 6]].
    주사위 초기 상태:
        dice: 주사위 6면의 초기값 [뒷면, 왼쪽면, 윗면, 오른쪽면, 앞면, 아랫면].
            초기: [2, 4, 1, 3, 5, 6] (아랫면=6).
    방향 벡터:
        dx, dy: 이동 방향 (동, 남, 서, 북) → [0, 1, 0, -1], [1, 0, -1, 0].
2. 주사위 굴리기 함수 (roll_dice)
    역할: 주사위를 주어진 방향으로 굴림.
    흐름:
        direction: 0(동), 1(남), 2(서), 3(북).
        각 방향별 면 이동:
            동쪽: 왼쪽→윗면, 윗면→오른쪽, 오른쪽→아랫면, 아랫면→왼쪽.
            남쪽: 뒷면→윗면, 윗면→앞면, 앞면→아랫면, 아랫면→뒷면.
            서쪽: 윗면→왼쪽, 오른쪽→윗면, 아랫면→오른쪽, 왼쪽→아랫면.
            북쪽: 윗면→뒷면, 앞면→윗면, 아랫면→앞면, 뒷면→아랫면.
        반환: 갱신된 dice.
3. BFS로 점수 계산 (calculate_score)
    역할: 주사위 위치에서 같은 값의 연속 칸 수를 계산해 점수 반환.
    흐름:
        visited: 방문 여부 체크 (N×M).
        queue: BFS용 deque, 시작점 (x, y) 추가.
        value: 기준 값 (grid[x][y]).
        count: 같은 값 칸 수 (초기 1).
        4방향 탐색:
            nx, ny가 격자 내이고, 방문 안 했고, 값이 value와 같으면:
                방문 표시, 큐 추가, count 증가.
        반환: value * count.
4. 주사위 이동 및 점수 계산
    초기화:
        x, y: 주사위 위치 (0, 0).
        direction: 초기 방향 (동쪽, 0).
        total_score: 총 점수.
    k번 반복:
        이동:
            nx, ny: 다음 위치 계산.
            격자 밖이면:
                direction = (direction + 2) % 4: 반대 방향 전환.
                새 위치 재계산.
            x, y 갱신.
        굴리기:
            dice = roll_dice(dice, direction): 주사위 상태 변경.
        점수 추가:
            total_score += calculate_score(x, y): 현재 위치 점수 합산.
        방향 결정:
            dice[5] > grid[x][y]: 아랫면 > 칸 값 → 시계 방향 (+1).
            dice[5] < grid[x][y]: 아랫면 < 칸 값 → 반시계 방향 (-1).
            같으면 방향 유지.
    5. 결과 출력
        출력:
            total_score: 총 점수 출력.

문제 분석
    문제: 백준 23288 "주사위 굴리기 2".
    입력:
        N, M, K: 격자 크기, 이동 횟수.
        N×M 격자.
    조건:
        주사위: 초기 위치 (0, 0), 방향 (동쪽).
        이동: 격자 밖이면 반대 방향.
        점수: 같은 값의 연속 칸 수 × 값 (BFS).
        방향: 아랫면(A)와 칸 값(B) 비교 (A>B: 시계, A<B: 반시계).
    출력: 총 점수.

시간 복잡도
    입력: O(N * M) (≈ 400).
    k번 반복:
        이동: O(1) per 턴.
        굴리기: O(1) per 턴.
        BFS: O(N * M) per 턴 (최대 격자 크기).
        총합: O(K * N * M) (K ≤ 10^3, N*M ≤ 400 → 약 4×10^5).
    결과: 2초 내 충분 (10^8 대비 여유).

결론
    정확성: 조건 충족, 샘플 통과.
    효율성: 시간 O(K * N * M), 공간 O(N * M)으로 적절.
    특징:
        BFS로 점수 정확히 계산.
        주사위 상태 관리 간단히 구현.
    검증: K, N, M 범위 내 효율적 동작.
"""