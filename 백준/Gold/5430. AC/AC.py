from collections import deque
import sys

input = sys.stdin.readline

# 테스트 케이스 처리
T = int(input())
for _ in range(T):
    p = input().strip()  # 명령어
    n = int(input())     # 배열 크기
    arr_input = input().strip()  # 배열 문자열
    
    # 배열 파싱
    if n == 0:
        arr = deque()
    else:
        arr = deque(map(int, arr_input[1:-1].split(',')))
    
    # 방향 플래그 (True: 정방향, False: 역방향)
    is_forward = True
    error = False
    
    # 명령어 수행
    for cmd in p:
        if cmd == 'R':
            is_forward = not is_forward  # 방향 전환
        elif cmd == 'D':
            if not arr:  # 빈 배열에서 삭제 시 오류
                error = True
                break
            if is_forward:
                arr.popleft()  # 정방향: 왼쪽 삭제
            else:
                arr.pop()  # 역방향: 오른쪽 삭제
    
    # 결과 출력
    if error:
        print("error")
    else:
        result = list(arr)
        if not is_forward:
            result.reverse()  # 역방향이면 뒤집기
        print(f"[{','.join(map(str, result))}]")
"""
방향 직접전환x 토글

문제 분석
 입력:
    T: 테스트 케이스 수.
    각 케이스:
      p: 명령어 문자열 (R: 뒤집기, D: 첫 요소 삭제).
      n: 배열 크기 (0 ≤ n ≤ 100,000).
      배열: [x1, x2, ..., xn] 형태의 문자열 (xi ≤ 10^9).
 조건:
    R: 배열 뒤집기 (방향 전환).
    D: 첫 번째 요소 삭제 (비어있으면 "error").
    명령 수행 후 배열 출력, 오류 시 "error".

 출력: 각 테스트 케이스 결과 (배열 또는 "error").

 접근법
    덱(deque)으로 양방향 조작 효율화.
    R은 실제 뒤집기 대신 방향 플래그 관리.
    D는 방향에 따라 앞/뒤에서 삭제.

코드 설명
1.입력 처리:
    p: 명령어 문자열 (예: "RDD").
    n: 배열 크기.
    arr_input: 배열 문자열 (예: "[1,2,3]").
    파싱:
        n == 0: 빈 덱 생성.
        그 외: [1:-1]로 대괄호 제거, split(',')로 분리, map(int, ...)로 정수 변환.

2.변수:
    arr: 덱으로 배열 저장.
    is_forward: 방향 플래그 (True: 정방향, False: 역방향).
    error: 오류 플래그.

3.명령어 처리:
    R: is_forward 토글 (실제 뒤집기 대신 방향만 기록).
    D:
        배열 비어있으면 error = True.
        정방향: popleft(), 역방향: pop().
4.출력:
    오류 시: "error".
    성공 시:
        덱을 리스트로 변환.
        역방향이면 reverse().
        [x1,x2,...] 형식으로 출력.

"""