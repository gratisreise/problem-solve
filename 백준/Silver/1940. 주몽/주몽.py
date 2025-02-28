import sys

ip = sys.stdin
op = sys.stdout

# 입력
n = int(ip.readline())
m = int(ip.readline())
nums = list(map(int, ip.readline().split()))

# m이 200,000 초과면 쌍 불가능
if m > 200000:
    print(0)
    exit()

# 숫자 존재 여부 저장
seen = set()
pair_count = 0

# 쌍 찾기
for num in nums:
    target = m - num
    if target in seen and target != num:  # 보수가 있고, 같은 수 아님
        pair_count += 1
        seen.remove(target)  # 중복 방지 위해 제거
    else:
        seen.add(num)

# 결과 출력
print(pair_count)