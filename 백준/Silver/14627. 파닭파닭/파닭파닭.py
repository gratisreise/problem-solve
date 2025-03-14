# 입력 처리
s, c = map(int, input().split())
a = [int(input()) for _ in range(s)]

# 초기 설정
sum_a = sum(a)  # 총 파 길이 합
lo, hi = 1, 10**9  # 탐색 범위
ret = 0  # 최대 파닭 길이

# 파닭 길이 가능 여부 체크
def check(mid):
    cnt = 0  # 만들 수 있는 파닭 개수
    for i in range(s):
        cnt += a[i] // mid  # 각 파로 만들 수 있는 파닭 수
    return cnt >= c  # C개 이상 가능한지

# 이진 탐색
while lo <= hi:
    mid = (lo + hi) // 2
    if check(mid):  # C개 이상 만들 수 있으면 더 큰 길이 탐색
        lo = mid + 1
        ret = mid
    else:  # C개 못 만들면 더 작은 길이 탐색
        hi = mid - 1

# 결과 출력 (남는 파 길이)
print(sum_a - ret * c)