import sys

# 입력과 출력을 위한 파일 객체
ip, op = sys.stdin, sys.stdout

# n: 재료의 개수, m: 목표 값
n = int(ip.readline())
m = int(ip.readline())

# 재료의 고유 번호 입력
nums = list(map(int, ip.readline().split()))

# m이 200,000보다 크면 불가능 (문제 조건)
if m > 200000:
    print(0)
    exit()

# 투 포인터를 사용하기 위해 재료 번호 정렬
nums.sort()

# 투 포인터 초기화
s, e = 0, len(nums) - 1  # 시작 포인터(s), 끝 포인터(e)
ret = 0  # 경우의 수를 저장할 변수

# 투 포인터 알고리즘 실행
while s < e:
    sum = nums[s] + nums[e]  # 두 재료의 합 계산
    if sum < m:  # 합이 목표 값보다 작으면
        s += 1  # 시작 포인터를 오른쪽으로 이동
    elif sum > m:  # 합이 목표 값보다 크면
        e -= 1  # 끝 포인터를 왼쪽으로 이동
    else:  # 합이 목표 값과 같으면
        ret += 1  # 경우의 수 증가
        e -= 1  # 끝 포인터를 왼쪽으로 이동 (다음 조합을 찾기 위해)

# 결과 출력
print(ret)

"""
시간복잡도: n + 10만 ~ 100만

"""