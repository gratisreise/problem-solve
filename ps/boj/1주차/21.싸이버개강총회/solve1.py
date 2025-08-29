import sys

# 입출력 속도 개선을 위해 sys 사용
ip, op = sys.stdin, sys.stdout

# 시간을 분 단위로 변환하는 함수 (HH:MM -> 분)
def convert(time_str):
    hours, minutes = map(int, time_str.split(':'))
    return hours * 60 + minutes

# 입력: 시작 시간 s, 종료 시간 e, 스트리밍 종료 시간 q
start_time, end_time, stream_end = ip.readline().rstrip().split()

# 분 단위로 변환
start_minutes = convert(start_time)
end_minutes = convert(end_time)
stream_end_minutes = convert(stream_end)

# 출석 체크용 집합과 출석 완료 카운트
attendees = set()
confirmed_count = 0

# 출입 기록 처리
while True:
    line = ip.readline().rstrip()
    if not line:  # 입력 종료
        break
    time_str, name = line.split()
    time_minutes = convert(time_str)
    
    # 시작 시간 이전에 입장한 경우
    if time_minutes <= start_minutes:
        attendees.add(name)
    # 종료 시간 ~ 스트리밍 종료 시간 사이에 퇴장한 경우
    elif end_minutes <= time_minutes <= stream_end_minutes:
        if name in attendees:
            confirmed_count += 1
            attendees.remove(name)  # 중복 카운트 방지

# 결과 출력
print(confirmed_count)