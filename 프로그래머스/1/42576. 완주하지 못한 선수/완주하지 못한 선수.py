def solution(participant, completion):
    value = 0
    answer = {}
    for part in participant:
        answer[hash(part)] = part
        value += hash(part)
    for comp in completion:
        value -= hash(comp)
    return answer[value]
    
"""
완주하지 못한 선수를 찾아라
동명이인 가능 
1. 참가자 - 숫자 맵생성
2. 완주자를 돌면서 숫자 빼기
3. 값이 +인 key 찾기

"""