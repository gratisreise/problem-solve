from collections import defaultdict

# 방향 벡터 (0~7)
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

# 입력 처리
n, m, k = map(int, input().split())
fireballs = [list(map(int, input().split())) for _ in range(m)]

# 초기화
for i in range(len(fireballs)):
    fireballs[i][0] -= 1  # 행 (0-based)
    fireballs[i][1] -= 1  # 열 (0-based)

# 시뮬레이션 실행
for _ in range(k):
    # 1. 모든 파이어볼 이동
    new_fireballs = defaultdict(list)
    for fireball in fireballs:
        x, y, m, s, d = fireball
        nx = (x + dx[d] * s) % n
        ny = (y + dy[d] * s) % n
        new_fireballs[(nx, ny)].append((m, s, d))

    # 2. 같은 칸에 있는 파이어볼 처리
    fireballs = []
    for pos, balls in new_fireballs.items():
        if len(balls) == 1:
            m, s, d = balls[0]
            fireballs.append([pos[0], pos[1], m, s, d])
        else:
            total_m = 0
            total_s = 0
            total_d = []
            for ball in balls:
                m, s, d = ball
                total_m += m
                total_s += s
                total_d.append(d % 2)  # 짝수/홀수 판단
            new_m = total_m // 5
            if new_m == 0:
                continue
            new_s = total_s // len(balls)
            if all(d == total_d[0] for d in total_d):
                new_d = [0, 2, 4, 6]  # 모두 짝수 또는 홀수
            else:
                new_d = [1, 3, 5, 7]
            for d in new_d:
                fireballs.append([pos[0], pos[1], new_m, new_s, d])

# 결과 계산
answer = sum(fireball[2] for fireball in fireballs)
print(answer)
