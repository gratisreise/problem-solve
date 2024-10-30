def solution(participant, completion):
    people = {name:0  for name in participant}
    for name in participant: people[name] += 1
    for name in completion: people[name] -= 1
    for name in people.keys():
        if people[name] != 0: return name
    
# 모든 참가자들에 대해 
# 참가자 이름에 대한 인원수 세기
# 완주자에 대해 이름을 하나씩 빼기
# 참가자가 0이 아니면 리턴