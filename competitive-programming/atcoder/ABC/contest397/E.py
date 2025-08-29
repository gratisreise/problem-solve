import sys

# 빠른 입력 처리
input = sys.stdin.readline

# 입력 처리
N, K = map(int, input().split())
NK = N * K

# 인접 리스트로 트리 구성 (0-based 인덱스)
T = [[] for _ in range(NK)]
for _ in range(NK - 1):
    u, v = map(lambda x: int(x) - 1, input().split())
    T[u].append(v)
    T[v].append(u)

# DFS 스택: (정점, 부모, 상태) - 상태 0: 하강, 1: 상승
st = [(0, -1, 0)]  # 루트 0에서 시작, 부모 없음
size = [1] * NK    # 각 정점의 서브트리 크기, 초기값 1

while st:
    v, p, t = st.pop()  # v: 현재 정점, p: 부모, t: 상태
    if t == 0:  # 하강 단계: 자식 탐색
        st.append((v, p, 1))  # 상승 단계 추가
        for u in T[v]:
            if u != p:  # 부모가 아닌 자식만
                st.append((u, v, 0))
    else:  # 상승 단계: 서브트리 크기 계산 및 조건 확인
        cnt = 0  # 유효 자식 수 (size > 0인 자식)
        for u in T[v]:
            if u != p:
                size[v] += size[u]  # 서브트리 크기 갱신
                if size[u] > 0:
                    cnt += 1
        
        # 조건 체크
        if size[v] > K or cnt >= 3:  # 경로 길이 초과 또는 분기过多
            print("No")
            exit()
        if size[v] < K and cnt >= 2:  # 경로 완성 불가
            print("No")
            exit()
        if size[v] == K:  # 경로 하나 완성
            size[v] = 0  # 해당 부분 제거

# 모든 조건 통과
print("Yes")