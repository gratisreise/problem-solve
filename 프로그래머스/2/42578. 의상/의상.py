def solution(clothes):
    kinds = {}
    for cloth in clothes:
        kinds[cloth[1]] = kinds.get(cloth[1], 0) + 1
    ret = 1
    for key in kinds.keys():
        ret *= (kinds[key]+1)
    return ret - 1
        
"""
옷의 조합의 수
경우의 수
종류별로 1개씩
종류별 갯수 + 1(안입는 경우)
모든 숫자 곱한 - 누드(1)


"""