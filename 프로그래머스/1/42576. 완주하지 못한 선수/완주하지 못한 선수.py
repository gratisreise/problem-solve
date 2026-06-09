def solution(participant, completion):
    name_dict = {}
    for p in participant:
        if p not in name_dict.keys():
            name_dict[p] = 0
        name_dict[p] += 1
    
    for name in completion:
        name_dict[name] -= 1
    
    for name in name_dict.keys():
        if name_dict[name] > 0:
            return name
    

"""
한명제외 전부 완주
완주x 이름 반환
동명이인 가능
각각의 이름을 맵으로 반환하고 각각의 이름이

1. 이름에 1더하기 10만
2. 나오는 이름 -= 1 하기 10만
3. 이제 이름이 양수인놈 찾기 10만
"""