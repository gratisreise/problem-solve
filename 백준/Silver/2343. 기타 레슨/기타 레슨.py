# 입력 처리
n, m = map(int, input().split())
a = list(map(int, input().split()))

# 초기 설정
sum_a = sum(a)  # 총 강의 길이 합
mx = max(a)     # 최대 강의 길이
lo, hi = 0, sum_a
ret = 0

# 블루레이 크기 가능 여부 체크
def check(mid):
    if mx > mid:  # 최대 강의가 mid보다 크면 불가능
        return False
    temp = mid    # 초기 블루레이 크기
    cnt = 0       # 블루레이 개수
    for i in range(n):
        if mid - a[i] < 0:  # 현재 블루레이에 못 넣으면 새 블루레이 시작
            mid = temp
            cnt += 1
        mid -= a[i]  # 강의 길이만큼 줄임
    if mid != temp:  # 마지막 블루레이 사용 확인
        cnt += 1
    return cnt <= m  # 블루레이 개수가 m 이하인지

# 이진 탐색
while lo <= hi:
    mid = (lo + hi) // 2
    if check(mid):  # 가능하면 더 작은 크기 탐색
        hi = mid - 1
        ret = mid
    else:           # 불가능하면 더 큰 크기 탐색
        lo = mid + 1

# 결과 출력
print(ret)