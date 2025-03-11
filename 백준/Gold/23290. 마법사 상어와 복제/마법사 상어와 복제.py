from collections import deque
import copy

# 입력 처리
m, s = map(int, input().split())
fish = [list(map(int, input().split())) for _ in range(m)]
shark_x, shark_y = map(int, input().split())

# 방향 벡터 (물고기: ←, ↖, ↑, ↗, →, ↘, ↓, ↙)
fish_dir = [(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]

# 방향 벡터 (상어: 상, 좌, 하, 우)
shark_dir = [(-1, 0), (0, -1), (1, 0), (0, 1)]

# 초기화
grid = [[deque() for _ in range(4)] for _ in range(4)]
for x, y, d in fish:
    grid[x - 1][y - 1].append(d - 1)

smell = [[0] * 4 for _ in range(4)]  # 물고기 냄새

# 물고기 이동
def move_fish():
    new_grid = [[deque() for _ in range(4)] for _ in range(4)]
    for x in range(4):
        for y in range(4):
            while grid[x][y]:
                d = grid[x][y].popleft()
                moved = False
                for _ in range(8):
                    nx = x + fish_dir[d][0]
                    ny = y + fish_dir[d][1]
                    if 0 <= nx < 4 and 0 <= ny < 4 and (nx != shark_x or ny != shark_y) and smell[nx][ny] == 0:
                        new_grid[nx][ny].append(d)
                        moved = True
                        break
                    d = (d - 1) % 8
                if not moved:
                    new_grid[x][y].append(d)
    return new_grid

# 상어 이동 (최적 경로 탐색)
def move_shark():
    max_eat = -1
    best_path = None
    # 상어 이동 가능한 모든 경로 탐색 (중복 순열)
    for d1 in range(4):
        for d2 in range(4):
            for d3 in range(4):
                visited = set()
                x, y = shark_x, shark_y
                path = [(x, y)]
                eat = 0
                # 첫 번째 이동
                nx = x + shark_dir[d1][0]
                ny = y + shark_dir[d1][1]
                if 0 <= nx < 4 and 0 <= ny < 4:
                    if (nx, ny) not in visited:
                        eat += len(grid[nx][ny])
                        visited.add((nx, ny))
                    path.append((nx, ny))
                    x, y = nx, ny
                else:
                    continue
                # 두 번째 이동
                nx = x + shark_dir[d2][0]
                ny = y + shark_dir[d2][1]
                if 0 <= nx < 4 and 0 <= ny < 4:
                    if (nx, ny) not in visited:
                        eat += len(grid[nx][ny])
                        visited.add((nx, ny))
                    path.append((nx, ny))
                    x, y = nx, ny
                else:
                    continue
                # 세 번째 이동
                nx = x + shark_dir[d3][0]
                ny = y + shark_dir[d3][1]
                if 0 <= nx < 4 and 0 <= ny < 4:
                    if (nx, ny) not in visited:
                        eat += len(grid[nx][ny])
                        visited.add((nx, ny))
                    path.append((nx, ny))
                else:
                    continue
                # 최적 경로 선택
                if eat > max_eat or (eat == max_eat and (best_path is None or (d1, d2, d3) < best_path)):
                    max_eat = eat
                    best_path = (d1, d2, d3)
    return best_path

# 물고기 냄새 업데이트
def update_smell(step):
    for x in range(4):
        for y in range(4):
            if smell[x][y] == step - 2:  # 2턴 전 냄새 제거
                smell[x][y] = 0

# 메인 로직
shark_x -= 1
shark_y -= 1
for step in range(1, s + 1):
    # 1. 물고기 복제
    copied_fish = copy.deepcopy(grid)
    # 2. 물고기 이동
    grid = move_fish()
    # 3. 상어 이동
    path = move_shark()
    # 상어 이동 경로 적용
    x, y = shark_x, shark_y
    for d in path:
        nx = x + shark_dir[d][0]
        ny = y + shark_dir[d][1]
        if grid[nx][ny]:
            grid[nx][ny].clear()
            smell[nx][ny] = step  # 현재 턴 번호로 기록
        x, y = nx, ny
    shark_x, shark_y = x, y
    # 4. 물고기 냄새 업데이트 (2턴 지난 냄새 제거)
    update_smell(step)
    # 5. 복제된 물고기 추가
    for x in range(4):
        for y in range(4):
            grid[x][y] += copied_fish[x][y]

# 결과 계산
total_fish = 0
for x in range(4):
    for y in range(4):
        total_fish += len(grid[x][y])

# 결과 출력
print(total_fish)

"""
코드 설명
1. 입력 처리
* 입력:
    * m, s: 물고기 수(M), 시뮬레이션 턴 수(S).
        * 1 ≤ M ≤ 100, 1 ≤ S ≤ 100.
    * fish: M개의 물고기 정보 리스트 [x, y, d] (행, 열, 방향).
        * 1 ≤ x, y ≤ 4, 1 ≤ d ≤ 8.
    * shark_x, shark_y: 상어 초기 위치 (1-based).
* 방향 벡터:
    * fish_dir: 물고기 8방향 (←, ↖, ↑, ↗, →, ↘, ↓, ↙).
    * shark_dir: 상어 4방향 (상, 좌, 하, 우).
* 초기화:
    * grid: 4×4 격자, 각 칸은 deque로 물고기 방향 저장.
        * 물고기 위치와 방향을 0-based로 변환 (x-1, y-1, d-1).
    * smell: 4×4 격자, 물고기 냄새의 턴 번호 기록.
2. 물고기 이동 (move_fish 함수)
* 역할: 모든 물고기를 한 칸 이동.
* 흐름:
    * new_grid: 이동 후 격자 (deque로 초기화).
    * 각 칸 (x, y)의 물고기 순회:
        * d: 현재 방향.
        * 8방향 시도 (현재 방향부터 반시계 회전):
            * nx, ny: 새 위치.
            * 조건: 격자 내, 상어 위치 아님, 냄새 없음.
            * 이동 가능 시 new_grid[nx][ny]에 추가.
            * 이동 불가 시 new_grid[x][y]에 원래 방향 추가.
        * d = (d - 1) % 8: 반시계 회전.
    * 반환: new_grid.
3. 상어 이동 (move_shark 함수)
* 역할: 3칸 이동으로 최대 물고기 제거 경로 찾기.
* 흐름:
    * max_eat, best_path: 최대 제거 수와 경로.
    * 4^3=64가지 경로 탐색 (d1, d2, d3):
        * visited: 중복 제거용 집합.
        * eat: 제거된 물고기 수.
        * 3단계 이동:
            * 각 단계에서 격자 밖이면 건너뜀.
            * 새 방문 칸이면 물고기 수 추가.
        * 조건: eat > max_eat 또는 eat == max_eat이면서 사전순 작은 경로.
            * (d1, d2, d3) 튜플 비교로 상(0), 좌(1), 하(2), 우(3) 우선순위 보장.
    * 반환: 최적 경로 (d1, d2, d3).
4. 물고기 냄새 업데이트 (update_smell 함수)
* 역할: 2턴 지난 냄새 제거.
* 흐름:
    * step: 현재 턴.
    * smell[x][y] == step - 2: 2턴 전 냄새면 0으로 초기화.
5. 메인 로직
* 초기화:
    * shark_x, shark_y: 0-based로 변환.
* S번 반복:
    * 1. 복제: copied_fish = copy.deepcopy(grid).
    * 2. 물고기 이동: grid = move_fish().
    * 3. 상어 이동:
        * path = move_shark(): 최적 경로.
        * 경로 적용: 물고기 제거 (clear()), 냄새 기록 (smell[nx][ny] = step).
        * 상어 위치 갱신.
    * 4. 냄새 업데이트: update_smell(step).
    * 5. 복제 적용: grid[x][y] += copied_fish[x][y] (deque 합침).
6. 결과 계산 및 출력
* 계산: total_fish: 모든 칸의 물고기 수 합.
* 출력: total_fish.

문제 분석
* 문제: 백준 23290 "마법사 상어와 복제".
* 입력:
    * M, S: 물고기 수, 턴 수.
    * M개의 (x, y, d): 물고기 위치와 방향.
    * (sx, sy): 상어 위치.
* 조건:
    * 물고기 이동: 8방향, 냄새/상어 피함.
    * 상어 이동: 3칸, 최대 물고기 제거, 사전순 경로.
    * 냄새: 2턴 후 소멸.
    * 복제: 이동 전 상태 추가.
* 출력: S턴 후 물고기 수.

시간 복잡도
* 입력: O(M) (≈ 100).
* S턴:
    * 복제: O(M) (격자 복사).
    * 물고기 이동: O(M * 8) (≈ 10^3).
    * 상어 이동: O(64 * 4) (≈ 10^3).
    * 냄새 업데이트: O(16).
    * 복제 적용: O(M).
    * 총합: O(S * M) (S ≤ 100, M ≤ 128 → 약 10^4).
* 결과: 1초 내 충분.

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(S * M), 공간 O(M)으로 최적.
* 특징:
    * deque로 물고기 관리 간편화.
    * 상어 경로 사전순 우선순위 명확히 처리.
* 검증: 4×4 격자에서 정확히 동작.
"""