def distance(arr1, arr2):
    return abs(arr1[0] - arr2[0]) + abs(arr1[1] - arr2[1])

def solution(numbers, hand):
    lr = "LR"
    like = 0 if hand == 'left' else 1
    pos = [[3,0], [3,2]]
    dic = {x:1 if x % 3 == 0 else 0 if (x-1) % 3 == 0 else -1 for x in range(10)}
    dic[0] = -1
    # print(dic)
    num_pos = {x:[(x-1)//3, (x-1) % 3] for x in range(1, 10)}
    num_pos[0] = [3, 1]
    # print(num_pos)
    ret = ''
    for num in numbers:
        cur_hand = dic[num]
        cur_pos = num_pos[num]
        cur_ret = ''
        # print(cur_hand)
        if cur_hand == -1:
            ldis = distance(pos[0], cur_pos)
            rdis = distance(pos[1], cur_pos)
            if ldis < rdis:
                pos[0] = cur_pos
                ret += lr[0]    
            elif ldis > rdis:
                pos[1] = cur_pos
                ret += lr[1]
            else:
                pos[like] = cur_pos
                ret += lr[like]
        else:
            pos[cur_hand] = cur_pos
            ret += lr[cur_hand]
    return ret
        
                
            
    
"""
왼엄:*, 오엄:# 에서 시작
1. 상하좌우 이동, 거리한칸 = 1
2. 1,4,7 = 왼
3. 3,6,9 = 오
4. 2,5,8,0 = 가까운놈, 거리같은면 우수,좌수 각자 우선

[자료구조]
엄지 좌표배열, 위치별 우선순위 손 맵, "LR", 숫자별 좌표
[로직]
1. 숫자를 순회
    1-1. 숫자마다 우선하는 손가락 선정
    1-2. 해당 위치의 손가락 움직이기
    1-3. ret에 += 로 위치 더해주기

"""