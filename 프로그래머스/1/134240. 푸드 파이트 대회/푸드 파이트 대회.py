def solution(food):
    ret = '0'
    for i in range(len(food) - 1, 0, -1):
        for _ in range(food[i]//2):
            ret = str(i) + ret
            ret += str(i)
    return ret
    
"""
중앙 물먹으면 승리
칼로리 낮은 것부터 먹음,
대칭,

"""