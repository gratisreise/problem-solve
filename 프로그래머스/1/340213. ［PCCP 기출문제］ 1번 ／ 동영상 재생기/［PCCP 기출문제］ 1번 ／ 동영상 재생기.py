def tos(time):
    time = time.split(":")
    return int(time[0])*60 + int(time[1])
def tom(ss):
    m = "00" + str(ss // 60)
    s = "00" + str(ss % 60)
    return m[-2:] + ":" + s[-2:]

def solution(video_len, pos, op_start, op_end, commands):
    video_len = tos(video_len)
    pos = tos(pos)
    op_start, op_end = tos(op_start), tos(op_end)
    if op_start <= pos <= op_end:
            pos = op_end
    for cmd in commands:
        if cmd == "next":
            pos = min(pos + 10,  video_len)
        else:
            pos = max(pos - 10, 0)
        if op_start <= pos <= op_end:
            pos = op_end
    return tom(pos)
    
"""
[조건]
10초 전, 10초 후, 오프닝 스킵
10초 전: "prev" 입력 => 10초전 이동, 10초 미만은 0분0초로 이동
10초 후: "next" 입력 => 10초후 이동, 10초 미만은 마지막으로 이동
오프닝스킵: 현재 오프닝구간일 경우 자동으로 op_end로 이동
입력이 모두 끝난 후 동영상의 위치

[아이디어]
commands를 돌면서 명령 수행, 모든 시간을 초단위로 변형후 계산
[자료구조]
[로직]
1. 커맨드 순회
    1-1. 커맨드 명령 수행
    1-2. 오프닝 구간 자동 스킵
2. 현재시간 출력 

"""