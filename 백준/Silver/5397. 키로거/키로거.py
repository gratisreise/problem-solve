from collections import deque
import sys

input = sys.stdin.readline
print = sys.stdout.write

# 테스트 케이스 수 입력
T = int(input().rstrip())

# 각 테스트 케이스 처리
for _ in range(T):
    # 키 입력 문자열
    keys = input().rstrip()
    
    # 커서 기준으로 왼쪽과 오른쪽을 deque로 관리
    left = deque()
    right = deque()
    
    # 키 입력 처리
    for key in keys:
        if key == '-':  # 백스페이스: 커서 앞 문자 삭제
            if left:
                left.pop()
        elif key == '<':  # 왼쪽 이동: 커서 왼쪽으로
            if left:
                right.appendleft(left.pop())
        elif key == '>':  # 오른쪽 이동: 커서 오른쪽으로
            if right:
                left.append(right.popleft())
        else:  # 일반 문자: 커서 위치에 추가
            left.append(key)
    
    # 결과 출력 (left + right 합침)
    print(''.join(left) + ''.join(right) + '\n')
