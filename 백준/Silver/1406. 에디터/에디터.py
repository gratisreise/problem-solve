from collections import deque
import sys

input = sys.stdin.readline
print = sys.stdout.write

# 초기 문자열 입력
init = input().rstrip()
left = deque(init)  # 커서 왼쪽
right = deque()     # 커서 오른쪽

# 명령어 수 입력
q = int(input().rstrip())

# 명령어 처리
for _ in range(q):
    line = input().rstrip()
    if not line:  # 빈 줄 무시
        continue
    command = line.split()
    op = command[0]
    
    if op == 'P':  # 커서 위치에 문자 추가
        add = command[1]
        left.append(add)
    elif op == 'L':  # 커서 왼쪽 이동
        if left:
            right.appendleft(left.pop())  # 왼쪽 끝에서 오른쪽 앞에 추가
    elif op == 'D':  # 커서 오른쪽 이동
        if right:
            left.append(right.popleft())  # 오른쪽 앞에서 왼쪽 끝에 추가
    elif op == 'B':  # 커서 앞 문자 삭제
        if left:
            left.pop()

# 결과 출력
print(''.join(left) + ''.join(right))