from collections import deque

# 입력 처리
n, m, t = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

# 방향 벡터 (미세먼지 확산: 우, 상, 좌, 하)
dy1 = [0, -1, 0, 1]
dx1 = [1, 0, -1, 0]
# 공기청정기 상단 순환 (우, 상, 좌, 하)
dy2 = [0, -1, 0, 1]
dx2 = [1, 0, -1, 0]
# 공기청정기 하단 순환 (우, 하, 좌, 상)
dy3 = [0, 1, 0, -1]
dx3 = [1, 0, -1, 0]

# 미세먼지 확산
def mise_go(dy, dx):
    temp = [[0] * m for _ in range(n)]  # 확산량 저장
    q = deque()
    # 미세먼지 위치 큐에 추가
    for i in range(n):
        for j in range(m):
            if a[i][j] != -1 and a[i][j] > 0:
                q.append((i, j))
    
    while q:
        y, x = q.popleft()
        spread = a[y][x] // 5  # 확산되는 양
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and a[ny][nx] != -1:
                temp[ny][nx] += spread
                a[y][x] -= spread
    
    # 확산량 적용
    for i in range(n):
        for j in range(m):
            a[i][j] += temp[i][j]

# 공기청정기 순환 경로 생성
def chung(sy, sx, dy, dx):
    v = []
    cnt = 0
    y, x = sy, sx
    while True:
        ny = y + dy[cnt]
        nx = x + dx[cnt]
        if ny == sy and nx == sx:
            break
        if ny < 0 or ny >= n or nx < 0 or nx >= m:
            cnt += 1
            ny = y + dy[cnt]
            nx = x + dx[cnt]
        if ny == sy and nx == sx:
            break
        v.append((ny, nx))
        y, x = ny, nx
    return v

# 공기청정기 작동 (순환)
def go(v):
    for i in range(len(v) - 1, 0, -1):
        a[v[i][0]][v[i][1]] = a[v[i-1][0]][v[i-1][1]]
    a[v[0][0]][v[0][1]] = 0  # 시작점은 0으로

# 공기청정기 위치 찾기 및 경로 생성
v1, v2 = [], []
flag = True
for i in range(n):
    for j in range(m):
        if a[i][j] == -1:
            if flag:
                v1 = chung(i, j, dy2, dx2)  # 상단 순환
                flag = False
            else:
                v2 = chung(i, j, dy3, dx3)  # 하단 순환

# 시뮬레이션
for _ in range(t):
    mise_go(dy1, dx1)  # 1. 미세먼지 확산
    go(v1)            # 2. 상단 공기청정기 작동
    go(v2)            # 3. 하단 공기청정기 작동

# 결과 계산
ret = 0
for i in range(n):
    for j in range(m):
        if a[i][j] != -1:
            ret += a[i][j]

# 결과 출력
print(ret)

"""
코드 설명
1. 입력 처리
* 입력:
    * n, m, t: 격자 크기(R×C), 시간(T).
        * 6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000.
    * a: R×C 격자 (a[y][x]로 접근).
        * -1: 공기청정기.
        * 0 이상: 미세먼지 양.
* 방향 벡터:
    * dy1, dx1: 미세먼지 확산 (우, 상, 좌, 하).
    * dy2, dx2: 상단 공기청정기 순환 (우, 상, 좌, 하).
    * dy3, dx3: 하단 공기청정기 순환 (우, 하, 좌, 상).
    * C++ 코드와 동일한 순서 유지.
2. 미세먼지 확산 (mise_go 함수)
* 역할: 미세먼지를 4방향으로 확산.
* 흐름:
    * temp: 확산량 저장 배열.
    * q: 미세먼지 위치 큐 (y, x 순서).
    * 격자 순회하며 미세먼지 위치 추가 (a[i][j] != -1 and > 0).
    * 큐 처리:
        * spread = a[y][x] // 5: 확산량.
        * 4방향 탐색 (ny, nx):
            * 격자 내이고 공기청정기(-1)가 아니면:
                * temp[ny][nx] += spread.
                * a[y][x] -= spread.
    * temp를 a에 적용.
3. 공기청정기 순환 경로 생성 (chung 함수)
* 역할: 공기청정기 순환 경로 계산.
* 흐름:
    * v: 경로 좌표 리스트 (y, x 순서).
    * cnt: 방향 인덱스.
    * (sy, sx)에서 시작:
        * 격자 밖이면 방향 전환 (cnt++).
        * 시작점으로 돌아오면 종료.
    * 반환: 순환 경로.
4. 공기청정기 작동 (go 함수)
* 역할: 경로 따라 미세먼지 이동.
* 흐름:
    * 경로 끝부터 시작점 전까지 이동 (a[v[i]] = a[v[i-1]]).
    * 시작점은 0으로 (정화).
5. 메인 로직
* 공기청정기 위치 찾기:
    * v1: 상단 경로 (첫 번째 -1).
    * v2: 하단 경로 (두 번째 -1).
* T번 반복:
    * mise_go(dy1, dx1): 미세먼지 확산.
    * go(v1): 상단 순환.
    * go(v2): 하단 순환.
6. 결과 계산 및 출력
* 계산: ret: 공기청정기(-1) 제외 미세먼지 합.
* 출력: ret.

문제 분석
* 문제: 백준 17144 "미세먼지 안녕!".
* 입력:
    * R, C, T: 격자 크기, 시간.
    * R×C 격자.
* 조건:
    * 미세먼지: 4방향 확산 (1/5씩).
    * 공기청정기: 상단(반시계), 하단(시계) 순환.
    * T초 후 남은 미세먼지 양.
* 출력: 미세먼지 총합.

시간 복잡도
* 입력: O(R * C) (≈ 2500).
* T번 반복:
    * 확산: O(R * C) per 턴.
    * 순환: O(R + C) per 경로.
    * 총합: O(T * R * C) (≈ 10^6).
* 결과: 2초 내 충분.

결론
* 정확성: C++ 코드와 동일한 로직, 샘플 통과.
* 효율성: 시간 O(T * R * C), 공간 O(R * C)으로 적절.
* 특징:
    * (y, x) 순서 유지하며 파이썬화.
    * deque로 효율적 큐 관리.
* 검증: 문제 조건 정확히 반영.
"""