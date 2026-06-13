def solution(players, callings):
    rank = {x:i for i,x in enumerate(players)}        
    for call in callings:
        now = rank[call] # 추월한놈 현재등수
        temp = players[now-1] # 추월 당할 놈 이름
        players[now-1] = players[now]
        players[now] = temp
        rank[call] = now-1
        rank[temp] = now
    return players
    
    
"""
[조건]
바로 앞 추월할 때 추월한 선수 이름 부름 
이름을 부르면 바로 앞에 놈이랑 자리를 바꾼다

[아이디어]
이름-등수 맵에 저장 이름 부를 때마다 나보다 하나 앞에 있는 놈이랑 스왑하면서 이름 - 등수 바꾸기


"""