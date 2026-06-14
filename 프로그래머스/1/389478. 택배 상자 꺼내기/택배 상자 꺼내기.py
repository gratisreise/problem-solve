def solution(n, w, num):
    y = (num-1) // w
    if y % 2 == 0:
        x = (num-1) % w
    else:
        x = w - ((num-1) % w) - 1
    
    height = (n-1) // w
    if height % 2 == 0:
        s, e = 0, (n-1) % w 
    else:
        s, e = w - ((n-1)%w) - 1, w-1
        
    if s <= x <= e:
        return height - y + 1
    else:
        return height - y
    
    
    
    
"""
[조건]
1~n 
왼쪽아래부터시작
아래있는 놈 꺼낼려면 위에거 꺼내야함 
몇개의 택배상자를 꺼내야(자기자신 포함)
어떤 숫자가 주어졌을 때 몇번을 w를 더해야 범위 바깥으로 넘어 가는지만 세면 되지 않나??

해당 숫자의 층은 x-1 // w 하면 나옴 
짝수면 왼->오, 홀수면 오 -> 왼
마지막 남은 놈들은 해당 인덱스 존재하는지 체크하기위해서 
층수, 시작점 

"""