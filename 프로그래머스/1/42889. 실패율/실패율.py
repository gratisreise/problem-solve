def solution(N, stages):
    ret = [i for i in range(1, N+1)]
    cur_stage = [0] * (N+2)
    
    for i in stages: cur_stage[i] += 1
    total_stage = [i for i in cur_stage]
    for i in range(N, 0, -1):
        total_stage[i] = cur_stage[i] + total_stage[i + 1]
    defat = {x:cur_stage[x]/total_stage[x] if total_stage[x] else 0 for x in range(1, N+1)}
    return sorted(ret, key = lambda x: defat[x], reverse=True)
# 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호 1 ~ 500
# 실패율 내림차 번호 오름차
# 도달한 유저 0이면 0

# 현재 멈춰있는 스테이지 번호가 담긴 배열을 입력받는다 
# 마지막 스테이지부터 다음 스테이지 도전하는 인원을 더하여 스테이지에 도달한 플레이어 수를 구한다
# 맵에 스테이지마다 실패율을 저장한다
# 스테이지의 번호가 담긴 배열을 정렬한다.

