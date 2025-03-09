from collections import deque

# 이동 방향 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def find_passenger(taxi_x, taxi_y, grid, passengers):
    if (taxi_x, taxi_y) in passengers:
        return (taxi_x, taxi_y, 0)
    q = deque([(taxi_x, taxi_y, 0)])
    visited = {(taxi_x, taxi_y)}
    candidates = []
    min_dist = float('inf')
    while q:
        x, y, dist = q.popleft()
        if dist > min_dist:
            break
        if (x, y) in passengers:
            candidates.append((x, y, dist))
            min_dist = dist
            continue
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < len(grid) and 0 <= ny < len(grid) and grid[nx][ny] == 0 and (nx, ny) not in visited:
                visited.add((nx, ny))
                q.append((nx, ny, dist + 1))
    if not candidates:
        return None
    candidates.sort(key=lambda x: (x[2], x[0], x[1]))  # 거리, 행, 열 순 정렬
    return candidates[0]

def move_to_dest(start_x, start_y, dest_x, dest_y, grid):
    q = deque([(start_x, start_y, 0)])
    visited = {(start_x, start_y)}
    while q:
        x, y, dist = q.popleft()
        if (x, y) == (dest_x, dest_y):
            return dist
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < len(grid) and 0 <= ny < len(grid) and grid[nx][ny] == 0 and (nx, ny) not in visited:
                visited.add((nx, ny))
                q.append((nx, ny, dist + 1))
    return -1

def start_taxi(taxi_x, taxi_y, fuel, grid, passengers):
    current_fuel = fuel
    current_x, current_y = taxi_x, taxi_y
    while passengers:
        # 승객 찾기
        passenger = find_passenger(current_x, current_y, grid, passengers)
        if passenger is None or current_fuel < passenger[2]:
            return -1
        px, py, dist = passenger
        current_fuel -= dist
        # 목적지 이동
        dest_x, dest_y = passengers[(px, py)]
        dist_to_dest = move_to_dest(px, py, dest_x, dest_y, grid)
        if dist_to_dest == -1 or current_fuel < dist_to_dest:
            return -1
        current_fuel -= dist_to_dest
        current_fuel += dist_to_dest * 2  # 연료 충전
        # 승객 제거 및 위치 갱신
        del passengers[(px, py)]
        current_x, current_y = dest_x, dest_y
    return current_fuel

# 입력 처리
n, m, fuel = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
taxi_x, taxi_y = map(int, input().split())
taxi_x -= 1
taxi_y -= 1
passengers = {}
for _ in range(m):
    px, py, ax, ay = map(int, input().split())
    passengers[(px - 1, py - 1)] = (ax - 1, ay - 1)

# 시뮬레이션 실행
result = start_taxi(taxi_x, taxi_y, fuel, grid, passengers)
print(result)

"""
문제 분석
    문제: 백준 19238 "스타트 택시".
    입력: 격자 크기(n×n), 승객 수(m), 초기 연료, 격자(0: 빈칸, 1: 벽), 택시 위치, 승객 출발/도착 위치.
    조건:
        택시가 가까운 승객 찾아 이동 → 목적지로 이동.
        연료 소모 후 목적지 도착 시 충전 (거리 × 2).
        모든 승객 이동 완료 시 연료 출력, 실패 시 -1.
    접근법: BFS로 최단 경로 탐색, 승객을 하나씩 처리.


코드 설명
1. 초기 설정
    역할: 4방향 이동과 BFS 준비.
    흐름: dx, dy 정의, deque 사용.
2. 승객 찾기 (find_passenger)
    역할: 택시에서 가까운 승객 찾기.
    흐름: BFS로 탐색 → 승객 후보 수집 → 거리/행/열 순으로 선택.
    개선: visited를 리스트 → set으로 변경, 조회 속도 향상.
3. 목적지 이동 (move_to_dest)
    역할: 승객 위치에서 목적지까지 거리 계산.
    흐름: BFS로 최단 경로 탐색 → 도달 시 거리 반환.
    개선: visited를 set으로 최적화.
4. 택시 운행 (start_taxi)
    역할: 승객 태우고 목적지 이동.
    흐름: 승객 찾기 → 이동 → 연료 충전 → 반복.
    개선: 전역 passengers 대신 매개변수로 전달, 변수명 명확화(current_fuel, current_x 등).
5. 입력 처리 및 실행
    역할: 입력 받아 시뮬레이션 실행.
    흐름: 입력 처리 → 택시 운행 → 결과 출력.

시간 복잡도
    BFS: O(n^2) (격자 크기).
    총합: O(m × n^2) (n ≤ 20, m ≤ 400 → 약 1.6×10^5).
    결과: 1초 내 충분.
공간 복잡도
    격자: O(n^2) ≈ 1600B.
    승객: O(m) ≈ 4.8KB.
    BFS: O(n^2) ≈ 1600B (set 사용).
    총합: 약 8KB (512MB 내 여유).
결론
    정확성: 문제 조건 충족 (최단 경로, 연료 계산).
    효율성:
        시간: O(m × n^2)으로 1초 내 동작.
        공간: 8KB로 제한 만족.
    개선점:
        visited를 set으로 변경 → O(1) 조회로 BFS 효율성 증가.
        함수 매개변수 추가로 전역 변수 의존성 감소.
        코드 가독성 향상 (변수명, 구조).
    검증: 기존 코드 대비 성능 개선, 문제 규칙 준수.
"""