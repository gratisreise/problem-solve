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


"""
문제 분석
입력:
테스트 케이스 수 T.
각 케이스: 길이 L의 키 입력 문자열 (1 ≤ L ≤ 1,000,000).
키 종류: 알파벳 대/소문자, 숫자, - (백스페이스), < (왼쪽 이동), > (오른쪽 이동).
동작:
문자: 커서 위치에 삽입, 커서 오른쪽 문자들은 오른쪽으로 이동.
-: 커서 앞 문자 삭제 (커서가 맨 앞이면 무시).
<: 커서 왼쪽으로 이동 (맨 앞이면 무시).
>: 커서 오른쪽으로 이동 (맨 끝이면 무시).
출력: 각 테스트 케이스의 최종 비밀번호.
시간 제한 고려
시간 제한 1초 ≈ 10^7~10^8 연산 (파이썬 기준).
최악: T * L ≈ 10 * 1,000,000 = 10^7. 연산당 O(1)이어야 함.
list의 중간 삽입/삭제는 O(n)이라 부적합. 양쪽 deque로 커서 기준 분리 필요.

코드 설명
자료구조
left: 커서 왼쪽 문자열 (deque).
right: 커서 오른쪽 문자열 (deque).
커서는 left 끝과 right 시작 사이에 위치.
연산
문자 입력: left.append(key) → O(1).
백스페이스 (-): left.pop() → O(1).
왼쪽 이동 (<): right.appendleft(left.pop()) → O(1).
오른쪽 이동 (>): left.append(right.popleft()) → O(1).
시간 복잡도
각 키 처리: O(1).
각 테스트 케이스: O(L) (L은 키 입력 길이).
총: O(T * L) ≈ O(10^7) → 1초 내 충분히 가능.
공간 복잡도
left, right: O(L).


검증
입력 크기: L ≤ 1,000,000, T ≤ 10 → 최악 10^7 연산, 시간 제한 내 처리 가능.
예외 처리:
백스페이스/화살표 시 커서 위치 체크 (if left, if right)로 안전.
빈 문자열 가능 (left, right 빈 경우 처리).
결론
이 코드는 파이썬으로 시간 제한 내에 문제 해결 가능.
양쪽 deque 방식은 C++의 연결 리스트를 모방하며, 모든 연산을 O(1)로 유지해 효율적.
제출 시 sys.stdin.readline으로 입출력 최적화 필수.
"""