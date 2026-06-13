def count(time):
    h = time // 100
    m = time % 100
    m += 10
    if m > 59:
        m -= 60
        h += 1
    return h*100 + m
    

def solution(schedules, timelogs, startday):
    idx = 1
    ret = 0
    for sch, time in zip(schedules, timelogs):
        now = startday-1
        bound = count(sch)
        cnt = 0
        for t in time:
            if t <= bound and now < 5:
                cnt += 1
            now = (now + 1) % 7
        if cnt == 5:
            ret += 1
    return ret    
    
    
    

"""
일주일동안 늦지 않은 놈에게 증정
출근 희망 + 10m 까지 어플로 출근
주말출근ㅠㅠ 영향x
시간은 모든 시각에 *100 + 분으로 표현
상품 받을 직원수 구하기


[아이디어]
시간로그 순회 하면서 자신의 시간을 지킨 놈들만 세주기

[자료구조]
[로직]
1. 스케줄, 타임로그 같이 순회
2. 스케줄에 맞는 시간안에 들어온 날짜 체크(주말제외)
3. 조건에 맞으면 i+1 넣어주기 
4. 출력


"""