import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
t, a = map(int, input().split())
b = [[0]*(a + 1)] + [[0] + list(input().strip()) for _ in range(t)]

# 1-based 격자
dp = [[0]*(a + 1) for _ in range(t+1)]
check = [[False]*(a+1) for _ in range(t+1)]
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]

def in_range(y, x):
    return 1 <= y <= t and 1 <= x <= a

def down(y, x):
    if not in_range(y, x) or b[y][x] == 'H':
        return 0
    if check[y][x]:
        print(-1)
        sys.exit(0)
    
    ret = dp[y][x]
    if ret:
        return ret
    
    check[y][x] = True 
    value = int(b[y][x])
    for i in range(4):
        ny, nx = y + dy[i] * value, x + dx[i] * value
        ret = max(ret, down(ny, nx) + 1)
    check[y][x] = False #원복
    dp[y][x] = ret
    return ret
#메인: (1, 1)에서 시작

print(down(1, 1))
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: (1,1)에서 시작해 최대 이동 횟수를 구한다.
* 조건:
    * 격자는 T×A 크기, 각 칸은 숫자(0~9) 또는 구멍('H').
    * 숫자만큼 상하좌우로 이동 가능.
    * 구멍('H')에 들어가거나 격자를 벗어나면 종료.
    * 무한 루프(사이클)가 발생하면 -1 출력.
* 입력: T(행), A(열), T줄의 문자열.
접근 아이디어
* DFS+DP:
    * 각 칸에서 이동 가능한 최대 횟수를 계산하며 메모이제이션.
    * 상태: (y, x)에서 최대 이동 횟수 → d[y][x].
* 사이클 감지:
    * 방문 체크(check)로 DFS 중 같은 칸을 다시 방문하면 사이클 → -1 출력.
* 점화식:
    * d[y][x] = max(d[ny][nx]) + 1 (4방향 중 최대값).
    * 기저: 구멍('H')이거나 범위 밖이면 0.
* 초기 조건:
    * (1,1)에서 시작, 이동 횟수 계산.
* 최종 결과:
    * d[1][1]이 최대 이동 횟수, 사이클이면 -1.
구현 전략
* 1-based 인덱스: 격자를 1부터 시작하도록 맞춤.
* 재귀 DFS: 4방향 탐색하며 최대값 갱신.
* 종료 조건: 사이클 감지 후 즉시 종료.

코드 설명
1. 입력 처리
* t, a: 행(T), 열(A) 크기.
* b: T×A 격자, 1-based로 0 행/열 추가.
* d: DP 배열, (y,x)에서 최대 이동 횟수 저장.
* check: 사이클 감지용 방문 체크 배열.
2. 격자 범위 확인 (in_range)
* y, x: 현재 위치.
* 1 ≤ y ≤ t, 1 ≤ x ≤ a면 True 반환.
3. DFS로 최대 이동 계산 (down)
* y, x: 현재 위치.
* 기저 조건:
    * 범위 밖이거나 'H'면 0 반환.
    * check[y][x]가 True면 사이클 → -1 출력 후 종료.
* 메모이제이션: d[y][x] 값이 있으면 반환.
* 탐색:
    * check[y][x] = True로 방문 표시.
    * value: 현재 칸의 숫자.
    * 4방향으로 value만큼 이동하며 최대값 갱신.
    * check[y][x] = False로 백트래킹.
* 반환: d[y][x].
4. 메인
* (1,1)에서 시작해 최대 이동 횟수 출력.

문제 분석
* 문제: 백준 1103 "게임".
* 입력: T, A, T줄 문자열 (격자).
* 출력: 최대 이동 횟수, 사이클이면 -1.
* 조건: 숫자만큼 이동, 구멍/범위 밖 종료.

시간 복잡도
* DFS: 각 칸 O(1) 처리, 최대 T×A 방문 → O(T×A).
* 총합: O(T×A) (T, A ≤ 50, ≈ 2500), 2초 내 충분.

결론
* 정확성: DFS+DP로 최대 이동 계산, 사이클 감지 포함.
* 효율성: 시간 O(T×A), 공간 O(T×A).
* 아이디어: 메모이제이션과 방문 체크로 최적화.
"""