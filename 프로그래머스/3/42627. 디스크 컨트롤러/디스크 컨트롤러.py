import heapq
from collections import  deque
def solution(jobs):
    jobs = [(i, x[0], x[1]) for i,x in enumerate(jobs)] # 번호, 요청, 소요
    jobs.sort(key = lambda x :(x[1], x[0]))
    
    jobs = deque(jobs)
    heap = []
    
    now = 0
    total_time = 0
    n = len(jobs)
    
    while heap or jobs:
        # 작업저장
        while jobs and jobs[0][1] <= now:
            idx, start, duration = jobs.popleft()
            heapq.heappush(heap, (duration, start, idx)) # 소요, 요청, 번호
        #작업수행
        if heap:
            duration, start, idx = heapq.heappop(heap)
            now += duration
            total_time += (now - start)
        else:
            now = jobs[0][1]
    
    return total_time // n
        
        
        
    
        



"""
우선순위 디스크에서 작업
1. (번호, 요청 시각, 소요 시간) 저장 => 처음 비어 있음
2. 작업x, 대기큐빔x => 우선순위 순으로 작업: 소요짧, 요청빠, 번호 작
3. 한번 점유하면 방해 불가
4. 마치는 시점 요청 시점 겹치면 => 선 작업 저장, 작업 완료, 작업 시작 =>  작업 마치자 마자 작업 시작 가능함: 같은 시간처리 가능
0부터 시작

[아이디어]
리스트를 순회하면서 요청시간보다 적은 놈들 대기큐에 넣고 작업 꺼내서 실시하기 


[로직]
1. 요청시간 순으로 오름차 정렬
2. 현재시간 보다 작거나 같은 놈들 전부 대기큐에 넣기
3. 대기큐에 남아있는 작업처리

"""