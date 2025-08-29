n = int(input())  # 노드 수
inputs = list(map(int, input().split()))  # 부모 노드 입력
rmv = int(input())  # 제거 노드
tree, root = [[] for _ in range(n)], 0  # 트리 인접 리스트, 루트
vis = [0]*n  # 방문 배열

def go(now):
    vis[now] = 1  # 현재 노드 방문
    ret, child = 0, 0  # 리프 노드 수, 자식 수
    for next in tree[now]:  # 자식 노드 탐색
        if vis[next] or next == rmv:  # 방문済 또는 제거 노드
            continue
        ret += go(next)  # 자식의 리프 노드 수 합산
        child += 1  # 자식 수 증가
    if child == 0:  # 자식 없으면 리프 노드
        ret += 1
    return ret

# 트리 구성
for i, num in enumerate(inputs):
    if num == -1:  # 루트 노드
        root = i
        continue
    tree[num].append(i)  # 부모 -> 자식 연결

# 결과 출력
print(0 if root == rmv else go(root))
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 트리에서 특정 노드를 제거한 후 남은 리프 노드 개수 구하기.
* 조건:
    * 노드 수: N (1 ≤ N ≤ 50).
    * 입력: 각 노드의 부모 노드 번호 (-1은 루트).
    * 제거 노드: rmv.
    * 리프 노드: 자식 노드가 없는 노드.
* 출력: 리프 노드 개수.
접근 아이디어
* 트리 표현:
    * 인접 리스트로 자식 노드 저장.
    * 부모가 -1인 노드를 루트로 설정.
* DFS:
    * 루트에서 시작해 제거 노드와 방문한 노드를 제외하며 탐색.
    * 각 노드에서:
        * 자식이 없으면 리프 노드 → 1 반환.
        * 자식이 있으면 자식들의 리프 노드 수 합산.
* 특수 경우:
    * 제거 노드가 루트면 트리 없음 → 0.
* 구현 전략:
    * 트리 구성 후 DFS로 리프 노드 계산.
    * 방문 배열로 중복 방지.
1. 입력 처리
* n: 노드 수.
* inputs: 각 노드의 부모 노드 번호 (-1은 루트).
* rmv: 제거할 노드.
* tree: 인접 리스트, 각 노드의 자식 노드 저장.
* root: 루트 노드 인덱스, 초기값 0.
* vis: 방문 배열, 초기값 0.
2. 트리 구성
* for i, num in enumerate(inputs):
    * num == -1: 루트 노드 → root = i.
    * 그 외: tree[num].append(i)로 부모(num)에 자식(i) 추가.
3. DFS 함수
* go(now):
    * vis[now] = 1: 현재 노드 방문.
    * ret, child: 리프 노드 수, 자식 노드 수.
    * for next in tree[now]: 자식 노드 순회:
        * vis[next] or next == rmv: 방문済 또는 제거 노드 → 스킵.
        * ret += go(next): 자식의 리프 노드 수 추가.
        * child += 1: 자식 수 증가.
    * if child == 0: 자식 없으면 리프 노드 → ret += 1.
    * return ret: 현재 노드의 리프 노드 수 반환.
4. 출력
* root == rmv: 루트 제거 시 트리 없음 → 0.
* 그 외: go(root)로 리프 노드 수 계산.
* print(...): 결과 출력.

문제 분석
* 문제: 백준 1068 "트리".
* 입력: N, N개의 부모 노드 번호, 제거 노드.
* 출력: 제거 후 리프 노드 개수.
* 조건: 리프는 자식 없는 노드, 제거 노드 포함 서브트리 제외.

시간 복잡도
* 트리 구성: O(N).
* DFS: O(N) (각 노드 1번 방문).
* 총합: O(N) (N ≤ 50, ≈ 50), 1초 내 충분.
"""