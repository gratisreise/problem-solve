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