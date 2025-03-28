# 입력 처리
n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
answer = 0

# 토네이도 이동 방향 (좌, 하, 우, 상)
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

# 모래 퍼지는 비율
ratio = [
    [(-1, 1, 0.01), (1, 1, 0.01), (-2, 0, 0.02), (2, 0, 0.02), (-1, 0, 0.07), (1, 0, 0.07), (-1, -1, 0.1), (1, -1, 0.1), (0, -2, 0.05)],
    [(-1, -1, 0.01), (-1, 1, 0.01), (0, -2, 0.02), (0, 2, 0.02), (0, -1, 0.07), (0, 1, 0.07), (1, -1, 0.1), (1, 1, 0.1), (2, 0, 0.05)],
    [(-1, -1, 0.01), (1, -1, 0.01), (-2, 0, 0.02), (2, 0, 0.02), (-1, 0, 0.07), (1, 0, 0.07), (-1, 1, 0.1), (1, 1, 0.1), (0, 2, 0.05)],
    [(1, -1, 0.01), (1, 1, 0.01), (0, -2, 0.02), (0, 2, 0.02), (0, -1, 0.07), (0, 1, 0.07), (-1, -1, 0.1), (-1, 1, 0.1), (-2, 0, 0.05)]
]

# 토네이도 시작 위치
x, y = n // 2, n // 2
direction = 0  # 초기 방향: 좌
step = 1      # 현재 방향으로 이동할 칸 수
count = 0     # 현재 방향으로 이동한 횟수

while True:
    # 토네이도 이동
    for _ in range(step):
        nx = x + dx[direction]
        ny = y + dy[direction]

        # 격자 밖으로 나가면 종료
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            print(answer)
            exit()

        # 모래 퍼뜨리기
        sand = grid[nx][ny]
        if sand == 0:
            x, y = nx, ny
            continue

        total = 0
        for rx, ry, rp in ratio[direction]:
            px = nx + rx
            py = ny + ry
            scattered = int(sand * rp)
            if 0 <= px < n and 0 <= py < n:
                grid[px][py] += scattered
            else:
                answer += scattered
            total += scattered

        # alpha 처리
        alpha = sand - total
        ax = nx + dx[direction]
        ay = ny + dy[direction]
        if 0 <= ax < n and 0 <= ay < n:
            grid[ax][ay] += alpha
        else:
            answer += alpha

        grid[nx][ny] = 0
        x, y = nx, ny

    # 방향 전환
    direction = (direction + 1) % 4
    count += 1
    if count == 2:
        step += 1
        count = 0
"""
코드 설명
1. 초기 설정
    입력 처리:
        n: 격자 크기(n×n).
        grid: n×n 격자의 모래 양을 리스트로 입력.
        answer: 격자 밖으로 나간 모래 합을 저장.
    방향 벡터:
        dx, dy: 토네이도 이동 방향(좌, 하, 우, 상)을 정의.
    모래 퍼짐 비율:
        ratio: 각 방향별 모래 퍼짐 위치와 비율을 리스트로 저장.
            예: 좌(0) 방향은 (-1, 1, 0.01) 등 9개 위치와 비율.
    토네이도 초기화:
        x, y: 격자 중앙(n//2, n//2)에서 시작.
        direction: 초기 방향(좌, 0).
        step: 이동 칸 수(1부터 시작).
        count: 방향별 이동 횟수 카운터.

2. 시뮬레이션
    전체 흐름: 토네이도가 나선형으로 이동하며 모래를 퍼뜨림.
2.1 토네이도 이동
    역할: 현재 방향으로 step만큼 이동.
    흐름:
        새 위치 (nx, ny) 계산.
        격자 밖이면 answer 출력 후 종료.
2.2 모래 퍼뜨리기
    역할: 이동한 칸의 모래를 비율대로 분산.
    흐름:
        sand: 현재 칸의 모래 양.
        모래가 없으면 위치만 갱신.
        비율별 분산:
            total: 퍼진 모래 합.
        각 (rx, ry, rp)에 대해:
            새 위치 (px, py) 계산.
            격자 안이면 grid[px][py]에 추가, 밖이면 answer 증가.
        alpha: 남은 모래 (sand - total).
            다음 칸 (ax, ay)에 추가, 격자 밖이면 answer 증가.
        현재 칸 모래 0으로 초기화.
2.3 방향 전환
    역할: 이동 방향과 step 조정.
    흐름:
        direction을 다음 방향으로 전환.
        count 증가, 2번 이동 시 step 증가 후 count 초기화.
3. 결과 출력
    역할: 격자 밖 모래 합 출력.
    흐름: 격자 밖으로 나가면 answer 출력 후 종료.

문제 분석
    문제: 백준 20057번 "마법사 상어와 토네이도".
    입력:
        N: 격자 크기.
        N×N 격자의 모래 양.
    조건:
        토네이도: 중앙에서 나선형 이동 (좌→하→우→상).
        모래 퍼짐: 지정된 비율로 분산, alpha는 나머지.
        격자 밖으로 나간 모래 합 계산.
    출력: 격자 밖 모래 총합.

시간 복잡도
    이동: O(n^2) (격자 크기만큼 이동).
    모래 퍼짐: O(1) per 이동 (상수 9개 위치).
    총합: O(n^2) (n ≤ 500 → 약 2.5×10^5).
    결과: 2초 내 충분.
결론
    정확성: 문제 조건 충족.
    효율성: 시간 O(n^2), 공간 O(n^2)으로 최적.
    특징:
        나선형 이동 로직 간단히 구현.
        모래 퍼짐 비율 배열로 관리.
    개선: main() 제거로 간소화.
"""