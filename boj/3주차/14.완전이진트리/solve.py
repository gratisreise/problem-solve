from collections import deque
import sys
ip, op = sys.stdin.readline, sys.stdout.write

n = int(ip().rstrip())  # 트리 깊이
nums = list(map(int, ip().rstrip().split()))  # 중위 순회 결과
q = deque()
q.append((0, len(nums)-1))  # 초기 구간

while q:
    tempq = deque()  # 다음 레벨 구간
    while q:  # 현재 레벨 처리
        l, r = q.popleft()  # 구간
        mid = (l+r)//2  # 루트 인덱스
        op(f"{nums[mid]} ")  # 루트 출력
        if l == r: continue  # 단일 노드
        tempq.append((l, mid-1))  # 왼쪽 서브트리
        tempq.append((mid+1, r))  # 오른쪽 서브트리
    op('\n')  # 레벨 끝 개행
    q = deque(tempq)  # 다음 레벨로 이동
    """
    문제 접근 방법과 아이디어
문제 이해
* 목표: 완전 이진 트리의 중위 순회 결과(노드 값)를 받아 각 레벨별로 노드를 출력.
* 조건:
    * 트리 깊이: K (1 ≤ K ≤ 10).
    * 노드 수: N = 2^K - 1 (1 ≤ N ≤ 1023).
    * 입력: 중위 순회 결과 (1 ≤ 값 ≤ 10,000, 중복 없음).
    * 완전 이진 트리: 모든 레벨이 꽉 찬 이진 트리.
    * 출력: 각 레벨의 노드 값을 공백으로 구분, 레벨별로 개행.
* 중위 순회:
    * 왼쪽 서브트리 → 루트 → 오른쪽 서브트리.
접근 아이디어
* BFS:
    * 중위 순회 배열에서 루트는 중간 위치에 있음.
    * 각 구간 [l, r]의 중간값(mid)은 해당 서브트리의 루트.
    * 레벨별로 처리:
        * 현재 구간의 루트를 출력.
        * 왼쪽 서브트리 [l, mid-1], 오른쪽 서브트리 [mid+1, r]를 다음 레벨로 전달.
    * BFS 방식으로 큐를 사용하여 구간을 관리, 레벨 단위로 출력.
* 상태 관리:
    * nums: 중위 순회 결과 배열.
    * q: 현재 레벨의 구간 (l, r).
    * tempq: 다음 레벨의 구간.
* 구현 전략:
    * 초기 구간 [0, N-1]에서 시작.
    * 각 레벨에서 구간의 중간값(루트) 출력.
    * 서브트리 구간을 다음 레벨 큐에 추가.
    * 레벨별 출력 후 개행.
1. 입력 처리
* ip, op = sys.stdin.readline, sys.stdout.write: 빠른 입출력.
* n: 트리 깊이 (K).
* nums: 중위 순회 결과 배열 (길이 2^K - 1).
* q = deque(): BFS 큐.
* q.append((0, len(nums)-1)): 초기 구간 [0, N-1].
2. BFS
* while q:
    * tempq = deque(): 다음 레벨 구간 저장.
    * 현재 레벨 처리:
        * while q:
            * l, r = q.popleft(): 현재 구간.
            * mid = (l+r)//2: 구간의 중간 인덱스 (루트).
            * op(f"{nums[mid]} "): 루트 값 출력.
            * if l == r: 단일 노드 → 서브트리 없음, 스킵.
            * tempq.append((l, mid-1)): 왼쪽 서브트리 구간 추가.
            * tempq.append((mid+1, r)): 오른쪽 서브트리 구간 추가.
    * op('\n'): 레벨 끝 개행.
    * q = deque(tempq): 다음 레벨로 이동.

문제 분석
* 문제: 백준 9934 "완전 이진 트리".
* 입력: K, 중위 순회 결과 (2^K - 1개).
* 출력: 각 레벨의 노드 값 (공백 구분, 레벨별 개행).
* 조건: 완전 이진 트리, 중위 순회 활용.

시간 복잡도
* 노드 수: N = 2^K - 1 (K ≤ 10, N ≤ 1023).
* 각 노드는 한 번씩 처리 (루트로 출력).
* BFS: O(N) ≈ O(2^K).
* 총합: O(2^K) ≈ 1023, 1초 내 충분.

    """