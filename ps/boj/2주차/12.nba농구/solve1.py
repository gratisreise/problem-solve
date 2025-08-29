def to_seconds(time_str):
    """MM:SS를 초 단위로 변환"""
    minutes, seconds = map(int, time_str.split(':'))
    return minutes * 60 + seconds

def to_time(seconds):
    """초를 MM:SS 형식으로 변환"""
    minutes = seconds // 60
    seconds = seconds % 60
    return f"{minutes:02d}:{seconds:02d}"

n = int(input())  # 골 횟수
score_diff = 0  # 점수 차이 (1번 - 2번)
team1_time = 0  # 1번 팀 이긴 시간
team2_time = 0  # 2번 팀 이긴 시간
prev_time = 0  # 이전 골 시간

for _ in range(n):
    team, time_str = input().split()  # 팀 번호, 시간
    team = int(team)
    curr_time = to_seconds(time_str)  # 현재 시간을 초로 변환
    
    # 이전 구간에서 이긴 팀 시간 계산
    if score_diff > 0:  # 1번 팀이 이기고 있었음
        team1_time += curr_time - prev_time
    elif score_diff < 0:  # 2번 팀이 이기고 있었음
        team2_time += curr_time - prev_time
    
    # 점수 갱신
    if team == 1:
        score_diff += 1
    else:  # team == 2
        score_diff -= 1
    
    prev_time = curr_time  # 현재 시간 저장

# 마지막 구간(현재 시간 ~ 48:00) 처리
if score_diff > 0:
    team1_time += to_seconds("48:00") - prev_time
elif score_diff < 0:
    team2_time += to_seconds("48:00") - prev_time

# 출력
print(to_time(team1_time))
print(to_time(team2_time))

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 48분간의 농구 경기에서 각 팀(1번, 2번)이 이기고 있던 시간(분:초)을 출력.
* 조건:
    * 골 횟수: N (1 ≤ N ≤ 100).
    * 입력: 골이 들어간 시간(MM:SS)과 팀 번호(1 또는 2).
    * 경기 시간: 정확히 48분(2880초).
    * 동점은 이긴 시간으로 계산되지 않음.
* 출력: 1번 팀과 2번 팀이 이기고 있던 시간 (MM:SS 형식).
접근 아이디어
* 시간 관리:
    * 골이 들어간 시간을 초 단위로 변환해 처리.
    * 각 골 사이의 시간 구간에서 점수 차이를 계산.
* 상태 추적:
    * 현재 점수 차이(1번 팀 - 2번 팀)를 유지.
    * 점수 차이 > 0: 1번 팀 이김.
    * 점수 차이 < 0: 2번 팀 이김.
    * 점수 차이 = 0: 동점.
* 시간 계산:
    * 이긴 구간의 시작과 끝 시간을 기록.
    * 각 구간의 길이를 누적.
* 구현 전략:
    * 입력된 골 시간을 정렬 (시간순).
    * 구간별로 점수와 이긴 팀 갱신.
    * 경기 종료(48:00)까지 누적 시간 계산.
코드 설명
1. 도우미 함수
* to_seconds(time_str):
    * 입력: "MM:SS" 형식 문자열.
    * 출력: 초 단위 정수 (예: "01:30" → 90초).
    * 분과 초를 분리 후 계산.
* to_time(seconds):
    * 입력: 초 단위 정수.
    * 출력: "MM:SS" 형식 문자열 (예: 90 → "01:30").
    * 2자리 맞춤 포맷 사용.
2. 입력 처리
* n: 골 횟수.
* score_diff: 점수 차이(1번 팀 - 2번 팀), 초기값 0.
* team1_time, team2_time: 각 팀의 이긴 시간(초), 초기값 0.
* prev_time: 이전 골 시간, 초기값 0.
3. 골 처리
* for _ in range(n): N번 반복.
    * team, time_str: 팀 번호(1/2), 시간(MM:SS).
    * curr_time = to_seconds(time_str): 시간을 초로 변환.
    * 이긴 시간 계산:
        * score_diff > 0: 이전 구간에서 1번 팀이 이김 → team1_time에 추가.
        * score_diff < 0: 2번 팀이 이김 → team2_time에 추가.
        * score_diff == 0: 동점 → 추가 없음.
    * 점수 갱신:
        * team == 1: score_diff += 1.
        * team == 2: score_diff -= 1.
    * prev_time = curr_time: 현재 시간 저장.
4. 마지막 구간 처리
* 경기 종료(48:00)까지:
    * score_diff > 0: 1번 팀 이김 → team1_time에 추가.
    * score_diff < 0: 2번 팀 이김 → team2_time에 추가.
    * 추가 시간: 48:00 - 마지막 골 시간.
5. 출력
* to_time(team1_time): 1번 팀 시간 출력.
* to_time(team2_time): 2번 팀 시간 출력.

문제 분석
* 문제: 백준 2852 "NBA 농구".
* 입력: N, N개의 (팀 번호, 시간).
* 출력: 각 팀의 이긴 시간(MM:SS).
* 조건: 48분 경기, 동점은 이긴 시간 아님.

시간 복잡도
* 입력 처리: O(N).
* 시간 변환: O(1) (상수 시간).
* 총합: O(N) (N ≤ 100, ≈ 100), 1초 내 충분.
"""