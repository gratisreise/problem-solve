from collections import deque

# 입력 처리
n, k = map(int, input().split())
belt = deque(map(int, input().split()))  # 벨트 내구도
robot = deque([False] * n)  # 로봇 위치 (0 ~ n-1만 사용)
step = 0  # 단계 수

while True:
    step += 1

    # 1. 벨트와 로봇 회전
    belt.rotate(1)
    robot.rotate(1)
    robot[n - 1] = False  # 내리는 위치 로봇 제거

    # 2. 로봇 이동
    for i in range(n - 2, -1, -1):
        if robot[i] and not robot[i + 1] and belt[i + 1] > 0:
            robot[i] = False
            robot[i + 1] = True
            belt[i + 1] -= 1
            robot[n - 1] = False  # 내리는 위치 로봇 제거

    # 3. 로봇 올리기
    if belt[0] > 0:
        robot[0] = True
        belt[0] -= 1

    # 4. 내구도 검사
    if belt.count(0) >= k:
        break

print(step)