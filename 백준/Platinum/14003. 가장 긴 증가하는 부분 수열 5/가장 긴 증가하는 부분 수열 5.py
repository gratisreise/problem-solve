from bisect import bisect_left

# 입력 처리
n = int(input())
nums = list(map(int, input().split()))

# 초기 설정
INF = 10**9 + 4        # 무한대 값
lis = [INF] * (n + 1)  # LIS 배열
ans = [(0, 0)] * n     # (위치, 값) 저장
len_lis = 0            # LIS 길이

# LIS 계산
for i in range(n):
    num = nums[i]
    pos = bisect_left(lis, num, 0, len_lis)  # num이 들어갈 위치
    if lis[pos] == INF:  # 새로운 길이 추가
        len_lis += 1
    lis[pos] = num       # 해당 위치 갱신
    ans[i] = (pos, num)  # 위치와 값 기록

# 결과 출력: LIS 길이
print(len_lis)

# LIS 수열 복원
stk = []
current_len = len_lis - 1
for i in range(n - 1, -1, -1):
    if ans[i][0] == current_len:  # LIS의 해당 위치에 맞는 값
        stk.append(ans[i][1])
        current_len -= 1
    if current_len < 0:           # 모든 값 찾으면 종료
        break

# 스택에서 꺼내어 출력 (오름차순)
print(*stk[::-1])