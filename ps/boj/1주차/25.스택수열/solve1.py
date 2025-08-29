import sys

ip, op = sys.stdin, sys.stdout

# 입력
n = int(ip.readline())
sequence = [int(ip.readline()) for _ in range(n)]

# 스택과 연산 기록
stack = []
operations = []

# 현재 push할 숫자
current_num = 1

# 수열 전체를 한 번에 처리
for target in sequence:
    # 목표 숫자까지 push
    while current_num <= target:
        stack.append(current_num)
        operations.append('+')
        current_num += 1
    
    # 스택 맨 위가 목표와 다르면 불가능
    if stack[-1] != target:
        op.write('NO\n')
        sys.exit()
    stack.pop()
    operations.append('-')

# 스택이 비었는지 확인 (필요 시)
if not stack:
    op.write('\n'.join(operations) + '\n')
else:
    op.write('NO\n')