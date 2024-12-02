from heapq import heappush as push, heappop as pop

def solution(jobs):
    ret, now, i = 0, 0, 0
    start = -1
    heap = []
    
    while i < len(jobs):
        # 이전 시작 ~ 현재
        for job in jobs:
            if start < job[0] <= now:
                push(heap, job[::-1])
        if len(heap) > 0:
            cur = pop(heap)
            start = now #시작 시간 = 현재로
            now += cur[0] #현재 시간 + 소요시간
            ret += now - cur[1] #현재 + 들어온 시작 시간
            i += 1 #인덱스 ++ 
        else:
            now += 1
        
        
    return ret // len(jobs)
"""
시간을 더할 때 중간에 시간이 스킵 되는 것은 이전 현재 시간과 현재의 현재시간을 범위 제한하여
찾는 것으로 해결
작업의 인덱스를 따로 두는 것으로 종료 설정
1. 모든 작업에 대하여
    1-1. 들어온 작업이 있는지 확인
    1-2. 작업이 있으면 
        1-2-1. 현재시간 + 소요시간
        1-2-2. 결과에 현재 - 요청 더하기
        1-2-3. 행동 인덱스 ++
    1-3. 작업이 없으면
        시간 +1
평균 반환시간을 반환
"""