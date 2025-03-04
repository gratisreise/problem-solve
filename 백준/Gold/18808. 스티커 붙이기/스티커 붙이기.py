import sys

input = sys.stdin.readline

# 스티커를 90도 시계 방향으로 회전하는 함수
def rotate(sticker):
    r, c = len(sticker), len(sticker[0])
    rotated = [[0] * r for _ in range(c)]  # 새로운 크기: c x r
    for i in range(r):
        for j in range(c):
            rotated[j][r - 1 - i] = sticker[i][j]
    return rotated

# 스티커를 붙일 수 있는지 확인하는 함수
def can_attach(laptop, sticker, x, y):
    r, c = len(sticker), len(sticker[0])
    n, m = len(laptop), len(laptop[0])
    # 스티커가 노트북 범위를 벗어나는지 확인
    if x + r > n or y + c > m:
        return False
    # 스티커가 다른 스티커와 겹치는지 확인
    for i in range(r):
        for j in range(c):
            if sticker[i][j] == 1 and laptop[x + i][y + j] == 1:
                return False
    return True

# 스티커를 붙이는 함수
def attach(laptop, sticker, x, y):
    r, c = len(sticker), len(sticker[0])
    for i in range(r):
        for j in range(c):
            if sticker[i][j] == 1:
                laptop[x + i][y + j] = 1

# 메인 로직
n, m, k = map(int, input().split())
laptop = [[0] * m for _ in range(n)]

for _ in range(k):
    r, c = map(int, input().split())
    sticker = [list(map(int, input().split())) for _ in range(r)]
    
    # 0°, 90°, 180°, 270° 회전 시도
    for _ in range(4):
        attached = False
        # 노트북의 모든 위치 탐색
        for i in range(n):
            for j in range(m):
                if can_attach(laptop, sticker, i, j):
                    attach(laptop, sticker, i, j)
                    attached = True
                    break
            if attached:
                break
        if attached:
            break
        sticker = rotate(sticker)  # 붙이지 못하면 회전

# 결과 출력: 노트북에 붙은 스티커 칸 수
count = sum(sum(row) for row in laptop)
print(count)


"""
해결 과정
1. 입력 처리 및 초기화
노트북은 n x m 크기의 2D 리스트로, 모든 칸을 0으로 초기화합니다.
스티커는 k개가 주어지며, 각 스티커는 r x c 크기의 2D 리스트로 입력받습니다.
2. 스티커 붙이기 로직
각 스티커에 대해 다음 단계를 수행합니다:

위치 탐색: 노트북의 (0, 0)부터 (n-1, m-1)까지 순차적으로 탐색하며 스티커를 붙일 수 있는지 확인.
붙일 수 있는지 확인: 스티커가 노트북 범위를 벗어나지 않고, 다른 스티커(1인 칸)와 겹치지 않는지 확인.
붙이기: 가능한 위치를 찾으면 해당 위치에 스티커를 붙이고 다음 스티커로 넘어감.
회전: 붙일 수 없으면 스티커를 90도 회전하고 다시 탐색. 최대 4번 시도.
버리기: 4번 회전해도 붙이지 못하면 스티커를 버림.
3. 회전 구현
스티커를 시계 방향으로 90도 회전하려면, r x c 크기의 2D 리스트를 c x r 크기로 변환합니다.
변환 규칙: 원래 (i, j) 위치의 값이 회전 후 (j, r-1-i) 위치로 이동.
4. 결과 계산
모든 스티커를 처리한 후, 노트북에서 1인 칸의 개수를 세어 출력.
"""