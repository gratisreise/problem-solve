def solution(n, stages):
    clear = [0] * (n+2)
    for num in stages:
        for i in range(1, num+1):
            clear[i] += 1
    
    failed_rate = {x:0 for x in range(1, n+1)}
    for i in range(1, n+1):
        if clear[i] == 0:
            failed_rate[i] = 0
        else:
            failed_rate[i] = (clear[i] - clear[i+1]) / clear[i]
    
    return sorted(failed_rate.keys(), key = lambda x: (-failed_rate[x], x))
    
    
"""
실패율 = (도달o and 클리어x 플레이어수) / (도달플레이어수)
N: 전체 스테이지수
stages: 사용자가 현재멈춰있는 스테이지 수 배열
n+1은 마지막까지 클리어
실패율이 높은 순으로 스테이지 번호 담긴 배열 반환, 실패율 같으면 작은번호
도달 유저수 0은 실패율0

각 스테이지 마다 실패율을 구하기
해당 배열을 기준으로 임의의 스테이지 번호 배열 정렬한 후 반환
도달한 사람은 그냥 전부 더하기 
도달o 클리x 플레이어 = 현재단계 - 다음단계 도달수 

1. 도달 배열 구하기
2. 도달 배열을 이용해 실패율 구하기
3. 실패율 내림차, 숫자 오름차 정렬
4. 반환
"""