from itertools import combinations
from copy import deepcopy

# 입력 처리
n, m, d = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 궁수의 위치 조합 생성
archer_positions = list(combinations(range(m), 3))

# 공격 가능한 적 찾기
def find_targets(archers, grid):
    targets = set()
    for archer in archers:
        x, y = n, archer  # 궁수의 위치
        min_dist = float('inf')
        target = None
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:  # 적이 있는 경우
                    dist = abs(x - i) + abs(y - j)
                    if dist <= d and dist < min_dist:
                        min_dist = dist
                        target = (i, j)
                    elif dist <= d and dist == min_dist and j < target[1]:
                        target = (i, j)
        if target:
            targets.add(target)
    return targets

# 시뮬레이션 실행
max_enemies = 0
for archers in archer_positions:
    temp_grid = deepcopy(grid)
    total_enemies = 0
    while True:
        # 공격할 적 찾기
        targets = find_targets(archers, temp_grid)
        # 적 제거
        for target in targets:
            if temp_grid[target[0]][target[1]] == 1:
                temp_grid[target[0]][target[1]] = 0
                total_enemies += 1
        # 적 이동
        temp_grid.pop()  # 마지막 행 제거
        temp_grid.insert(0, [0] * m)  # 첫 행에 빈 행 추가
        # 적이 더 이상 없는지 확인
        if not any(1 in row for row in temp_grid):
            break
    # 최대값 갱신
    if total_enemies > max_enemies:
        max_enemies = total_enemies

# 결과 출력
print(max_enemies)
"""

코드 설명
1. 입력 처리
    입력:
        n, m, d: 격자 행 수(N), 열 수(M), 공격 거리 제한(D).
            1 ≤ N, M ≤ 15, 1 ≤ D ≤ 10.
        grid: N×M 격자, 0(빈 칸) 또는 1(적)로 구성.
        예: grid = [[0, 1, 0], [1, 0, 1], [0, 0, 1]].
    궁수 위치 조합:
        archer_positions: M개의 열 중 3개를 선택하는 조합 생성 (combinations(range(m), 3)).
            예: M=5면 [(0, 1, 2), (0, 1, 3), ...].
2. 공격 가능한 적 찾기 (find_targets 함수)
    역할: 궁수 위치에서 공격 가능한 적을 찾음.
    흐름:
        targets: 제거할 적의 좌표를 저장하는 집합(set).
        각 궁수 archer (x=n, y=archer)에 대해:
            모든 격자 칸 (i, j) 순회.
            적이 있으면 (grid[i][j] == 1):
                거리 계산: dist = abs(x - i) + abs(y - j) (맨해튼 거리).
                조건: dist <= d (거리 제한 내).
                최소 거리(min_dist) 갱신:
                    거리가 더 작으면 target = (i, j).
                    거리가 같고 열(j)이 더 작으면 갱신 (가장 왼쪽 우선).
            선택된 target을 targets에 추가.
        반환: 중복 제거된 공격 대상 집합.
3. 시뮬레이션
    전체 흐름: 각 궁수 조합에 대해 적 제거와 이동을 반복.
    변수:
        max_enemies: 제거된 최대 적 수.
    단계:
        궁수 조합 탐색:
            for archers in archer_positions: 모든 조합 시도.
            temp_grid = deepcopy(grid): 격자 복사 (원본 유지).
            total_enemies: 현재 조합에서 제거된 적 수.
        반복 시뮬레이션:
            공격:
                targets = find_targets(archers, temp_grid): 공격 대상 찾기.
                각 target에 대해:
                    temp_grid[target[0]][target[1]] == 1이면 0으로 변경, total_enemies 증가.
            적 이동:
                temp_grid.pop(): 마지막 행 제거 (적이 성으로 이동).
                temp_grid.insert(0, [0] * m): 첫 행에 빈 행 추가 (적 이동).
            종료 조건:
                if not any(1 in row for row in temp_grid): 격자에 1이 없으면 종료.
        최대값 갱신:
            if total_enemies > max_enemies: 최대 제거 수 갱신.
4. 결과 출력
    출력:
        max_enemies: 최대 제거된 적 수 출력.

        
문제 분석
    문제: 백준 17135 "캐슬 디펜스".
    입력:
        N, M, D: 격자 크기와 공격 거리.
        N×M 격자 (0 또는 1).
    조건:
        궁수 3명 배치 (N행의 M열 중 3개 선택).
        공격: 거리 D 이내의 가장 가까운 적 (가장 왼쪽 우선).
        적 이동: 한 칸 아래로, 성(N행)에 닿으면 사라짐.
        목표: 제거 가능한 최대 적 수.
    출력: 최대 제거 수.

접근 방법
    아이디어:
        궁수 위치를 조합으로 완전 탐색 (M C 3).
        각 조합에서 시뮬레이션:
            공격: 거리 D 내 최소 거리 적 제거.
            이동: 격자 행 이동.
        최대 제거 수 계산.
    구현:
        find_targets: 궁수별 공격 대상 선택.
        시뮬레이션 반복으로 적 처리.

시간 복잡도
    조합 생성: O(M C 3) (M ≤ 15 → 약 455).
    시뮬레이션:
        공격: O(N * M) per 턴 (최대 N번 이동 → O(N^2 * M)).
        총합: O((M C 3) * N^2 * M) (≈ 10^6).
    결과: 2초 내 충분 (10^8 대비 여유).

결론
    정확성: 문제 조건 충족, 샘플 통과.
    효율성: 시간 O((M C 3) * N^2 * M), 공간 O(N * M)으로 적절.
    특징:
        조합과 시뮬레이션으로 완전 탐색.
        거리 계산과 우선순위 명확히 처리.
    검증: N, M 작아 완전 탐색 가능.
"""