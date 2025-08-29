n, k = map(int, input().split())  # n: 수열의 길이, k: 연속된 수의 개수
nums = list(map(int, input().split()))  # 수열 입력

# 누적 합 배열 초기화
psum = [0] * (n + 1)

# 누적 합 계산
for i in range(1, n + 1):
    psum[i] = psum[i - 1] + nums[i - 1]

# 최댓값을 저장할 변수 (초기값은 매우 작은 값)
ret = -1e9

# 연속된 k개의 수의 합 중 최댓값 찾기
for i in range(k, n + 1):
    ret = max(ret, psum[i] - psum[i - k])

# 결과 출력
print(ret)

""""""