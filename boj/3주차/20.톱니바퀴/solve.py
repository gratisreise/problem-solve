import sys

input = sys.stdin.readline

# 톱니바퀴 초기 상태 입력
gears = []
for _ in range(4):
    gears.append(list(map(int, input().rstrip())))

# 회전 횟수 입력
k = int(input())

# 회전 함수
def rotate(gear, direction):
    if direction == 1:  # 시계 방향
        gears[gear].insert(0, gears[gear].pop())
    else:  # 반시계 방향
        gears[gear].append(gears[gear].pop(0))

# 회전 명령 처리
for _ in range(k):
    gear_num, direction = map(int, input().split())
    gear_num -= 1  # 톱니바퀴 번호를 0부터 시작하도록 조정

    # 회전할 톱니바퀴와 방향 저장
    rotate_info = [(gear_num, direction)]

    # 왼쪽 톱니바퀴 확인
    left_gear = gear_num - 1
    left_direction = direction
    while left_gear >= 0:
        if gears[left_gear][2] != gears[left_gear + 1][6]:
            left_direction *= -1
            rotate_info.append((left_gear, left_direction))
            left_gear -= 1
        else:
            break

    # 오른쪽 톱니바퀴 확인
    right_gear = gear_num + 1
    right_direction = direction
    while right_gear < 4:
        if gears[right_gear][6] != gears[right_gear - 1][2]:
            right_direction *= -1
            rotate_info.append((right_gear, right_direction))
            right_gear += 1
        else:
            break

    # 톱니바퀴 회전
    for gear, direction in rotate_info:
        rotate(gear, direction)

# 점수 계산
score = 0
for i in range(4):
    if gears[i][0] == 1:
        score += 2**i

print(score)
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: K번의 회전 후 톱니바퀴 상태를 기반으로 점수 계산.
* 조건:
    * 톱니바퀴: 4개, 각 8개 톱니.
    * 톱니: 0 (N극), 1 (S극).
    * 회전:
        * 시계 방향 (1): 마지막 톱니가 첫 번째로.
        * 반시계 방향 (-1): 첫 번째 톱니가 마지막으로.
    * 인접 톱니바퀴:
        * i번 바퀴의 2번 톱니와 i+1번 바퀴의 6번 톱니 비교.
        * 극이 다르면 반대 방향 회전.
    * 입력:
        * 4개 톱니바퀴 상태 (8자리 0/1 문자열).
        * 회전 횟수 K (1 ≤ K ≤ 100).
        * K개의 회전 정보 (톱니바퀴 번호 1~4, 방향 1/-1).
    * 점수:
        * i번 바퀴의 12시(0번) 톱니가 S극(1)이면 2^i 점.
* 출력: 총 점수.
접근 아이디어
* 시뮬레이션:
    * 각 회전 명령마다:
        * 선택된 톱니바퀴와 인접 바퀴의 회전 여부 결정.
        * 극 비교로 연쇄 회전 계산.
        * 회전 수행.
    * 최종 상태로 점수 계산.
* 상태 관리:
    * gears: 4×8 배열 (각 톱니바퀴의 톱니 상태).
    * rotate_info: 회전할 바퀴와 방향 리스트.
* 구현 전략:
    * 입력된 톱니바퀴 상태 저장.
    * 각 회전 명령:
        * 선택 바퀴 기준 왼쪽/오른쪽 바퀴의 극 비교.
        * 회전 정보 수집 후 일괄 회전.
    * 최종 점수: 0번 톱니가 1인 경우 2^i 합산.
1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* gears: 4개의 톱니바퀴 상태 (각 8개 톱니, 0/1 리스트).
* k: 회전 횟수.
* 회전 정보: gear_num (1~4), direction (1/-1).
2. 회전 함수
* rotate(gear, direction):
    * gear: 톱니바퀴 인덱스 (0~3).
    * direction:
        * 1 (시계): 마지막 톱니를 맨 앞으로 (pop() → insert(0)).
        * -1 (반시계): 첫 톱니를 맨 뒤로 (pop(0) → append).
3. 회전 명령 처리
* for _ in range(k):
    * gear_num, direction: 입력, gear_num -= 1 (0-based).
    * rotate_info = [(gear_num, direction)]: 선택 바퀴 회전 정보.
    * 왼쪽 확인:
        * left_gear = gear_num - 1, left_direction = direction.
        * while left_gear >= 0:
            * gears[left_gear][2] != gears[left_gear + 1][6]: 극 다름 → 회전.
            * left_direction *= -1: 반대 방향.
            * rotate_info.append((left_gear, left_direction)).
            * left_gear -= 1.
            * 극 같으면 break.
    * 오른쪽 확인:
        * right_gear = gear_num + 1, right_direction = direction.
        * while right_gear < 4:
            * gears[right_gear][6] != gears[right_gear - 1][2]: 극 다름 → 회전.
            * right_direction *= -1.
            * rotate_info.append((right_gear, right_direction)).
            * right_gear += 1.
            * 극 같으면 break.
    * 회전 실행:
        * for gear, direction in rotate_info:
            * rotate(gear, direction) 호출.
4. 점수 계산
* score = 0.
* for i in range(4):
    * gears[i][0] == 1: 12시 톱니가 S극 → score += 2**i.
* print(score): 총 점수 출력.

문제 분석
* 문제: 백준 14891 "톱니바퀴".
* 입력: 4개 톱니바퀴 상태, K, K개 회전 정보.
* 출력: 최종 점수.
* 조건: 인접 톱니 극 비교, 연쇄 회전, 점수 계산.

시간 복잡도
* 입력 처리: O(1) (고정 4×8 격자).
* 회전 명령: K ≤ 100.
    * 각 명령:
        * 좌우 확인: O(4) (최대 4개 바퀴).
        * 회전: O(1) (리스트 조작).
    * 총합: O(K * 4) ≈ O(400).
* 점수 계산: O(4).
* 총합: O(K), 1초 내 충분.
"""