def solution(friends, gifts):
    dic1 = {x:0 for x in friends} # 준수 
    dic2 = {x:0 for x in friends} # 받은수 
    dic3 = {} # 주고받은 수
    for g in gifts:
        A, B = g.split()
        if g not in dic3.keys():
            dic3[g] = 0
        dic1[A] += 1
        dic2[B] += 1
        dic3[g] += 1
        
    dic4 = {x:0 for x in friends}
    for f in friends:
        dic4[f] =  dic1[f] - dic2[f]
    print(dic4)
    
    dic5 = {x:0 for x in friends} # 받을 선물 수
    l = len(friends)
    for i in range(l):
        for j in range(i+1, l):
            A, B = friends[i], friends[j]
            AB, BA = A + " " + B, B + " " + A
            if AB not in dic3.keys():
                dic3[AB] = 0
            if BA not in dic3.keys():
                dic3[BA] = 0
            if dic3[A + " " + B] > dic3[B + " " + A]:
                dic5[A] += 1
            elif dic3[A + " " + B] < dic3[B + " " + A]:
                dic5[B] += 1
            else: # 없거나 같으면
                if dic4[A] > dic4[B]:
                    dic5[A] += 1
                elif dic4[A] < dic4[B]:
                    dic5[B] += 1
    return max(dic5[x] for x in friends)
                
        
        

"""
다음달에 누가 선물 많이 받을지 예측
이번달에 더 많은 선물 준 사람이 다음달에 하나더 받음
같거나 없으면 => 선물지수 큰사람이 작은 사람에게 받음
선물지수 = 준거 - 받은거
선물지수같으면 주고받지 않음 
선물을 가장 많이받은 놈의 선물의 수

[아이디어]
선물을 돌면서 사람-준수, 사람-받은수, 사람-선물지수
A B:숫자 로 누가 누구에게 얼마 줬는지 저장
friends를 돌면서 각각  사람-다음달 선물수 저장(조합)
순회하면서 가장 큰값 구하기
[자료구조]
사람-선물준수, 사람-선물받은수, 사람-선물지수, A B: 숫자(주고받은 선물수)
사람-받을 선물수
[로직]
1. 선물정보 순회
 1-1. 사람-선물준수
 1-2. 사람-선물받은수 
 1-3. A B: 선물수넣기
2.friends 돌면서 선물지수 채우기
3.friends 조합순회하면서 이름: 받을 선물 수 채우기
"""