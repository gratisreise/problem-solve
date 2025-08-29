from collections import deque
import sys

# 입력 처리
F, S, G, U, D = map(int, sys.stdin.readline().split())

# 시작 층과 목표 층이 같은 경우
if S == G:
    print(0)
    sys.exit()

# 방문 배열 초기화 (1-based)
visited = [-1] * (F + 1)
visited[S] = 0  # 시작 층 방문 처리

# BFS 큐 초기화
queue = deque([S])

# BFS 탐색
while queue:
    current = queue.popleft()
    
    # 이동 가능한 두 방향 (U층 위, D층 아래)
    for move in [current + U, current - D]:
        # 유효한 층이고 방문하지 않은 경우
        if 1 <= move <= F and visited[move] == -1:
            visited[move] = visited[current] + 1  # 이동 횟수 기록
            # 목표 층 도달 시 출력
            if move == G:
                print(visited[move])
                sys.exit()
            queue.append(move)

# 모든 탐색 후 도달 실패
print("use the stairs")
"""
코드 설명
1. 입력 처리
* 입력:
    * F, S, G, U, D: 총 층수(F), 시작 층(S), 목표 층(G), 위로 이동 거리(U), 아래로 이동 거리(D).
        * 1 ≤ S, G ≤ F ≤ 10^6, 0 ≤ U, D ≤ 10^6.
    * sys.stdin.readline: 빠른 입력 처리.
2. 초기 조건 확인
* 조건: if S == G.
    * 시작 층과 목표 층이 같으면 이동 필요 없음.
    * 출력: 0 후 종료 (sys.exit()).
3. 초기 설정
* 방문 배열:
    * visited: 1-based 배열 [F+1] (0번 인덱스 사용 안 함).
    * 초기값: -1 (미방문 상태).
    * visited[S] = 0: 시작 층 방문 처리 (이동 횟수 0).
* 큐 초기화:
    * queue: BFS용 deque.
    * queue.append(S): 시작 층 추가.
4. BFS 탐색
* 역할: S층에서 G층까지 최소 이동 횟수 계산.
* 흐름:
    * while queue: 큐가 빌 때까지.
        * current: 현재 층.
        * 이동 방향: current + U (위로), current - D (아래로).
        * 각 이동 move에 대해:
            * 조건:
                * 1 <= move <= F: 격자 내 (1~F층).
                * visited[move] == -1: 미방문.
            * 방문 처리: visited[move] = visited[current] + 1 (이전 횟수 + 1).
            * 목표 도달: move == G이면:
                * visited[move] 출력 후 종료 (sys.exit()).
            * 큐에 추가: queue.append(move).
5. 결과 출력
* 출력: "use the stairs".
    * BFS 종료 후에도 G층에 도달 못 하면 엘리베이터로 불가능.

문제 분석
* 문제: 백준 5014 "스타트링크".
* 입력:
    * F, S, G, U, D: 총 층수, 시작 층, 목표 층, 위로 이동, 아래로 이동.
* 조건:
    * S층에서 G층까지 최소 버튼 클릭 횟수.
    * 이동: U층 위, D층 아래.
    * 도달 불가능하면 "use the stairs".
* 출력: 최소 횟수 또는 "use the stairs".

시간 복잡도
* 입력: O(1).
* BFS:
    * 상태: 최대 F개 층.
    * 각 층당 이동: 2방향 (U, D).
    * 총합: O(F) (F ≤ 10^6 → 약 10^6).
* 결과: 1초 내 충분 (10^8 대비 여유).

공간 복잡도
* visited: O(F) ≈ 4MB (F ≤ 10^6).
* queue: O(F) 최악 경우 (≈ 4MB).
* 총합: 약 8MB (128MB 내 여유).

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(F), 공간 O(F)으로 최적.
* 특징:
    * 1차원 BFS로 간단히 구현.
    * 목표 도달 시 즉시 종료로 최적화.
    * 방문 배열로 거리와 방문 여부 동시 관리.
* 검증: F 범위 내 효율적 동작.
"""