import math

def solution(progresses, speeds):
    answer = []
    n = len(progresses)
    
    # 각 작업의 배포 가능일 계산
    days_left = [math.ceil((100 - progresses[i])/ speeds[i]) for i in range(n)]
    
    count = 0 # 배포될 작업의 수 카운트
    max_day = days_left[0] # 현재 작업중 가장 먼저 배포될 작업
    
    for i in range(n):
        if days_left[i] <= max_day: # 배포 예정일이 기준 배포일보다 빠르면
            count += 1
        else: # 배포 예정일이 기준 배포일보다 느리면
            answer.append(count)
            count = 1
            max_day = days_left[i]
    
    answer.append(count) # 마지막으로 카운트된 작업들을 함께 배포
    return answer
# 1. 각 작업의 배포 가능일을 구합니다.
# 2. 작업을 진행하며 배포 가능일이 첫 번째 작업일 보다 빠른 작업들은 함께 배포합니다.
# 3. 첫 번째 작업의 배포 가능일보다 늦은 작업이 나오면, 2단계와 유사하게 해당 
#    작업의 배포일을 기준으로 뒤의 작업들을 배포합니다. 이를 모든 작업이 완료될 때까지 반복한다.