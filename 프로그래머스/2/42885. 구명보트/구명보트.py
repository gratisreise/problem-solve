def solution(people, limit):
    people.sort()
    l, r = 0, len(people) - 1
    
    print(people)
    
    ret = 0
    while l <= r:
        ssum = people[l] + people[r]    
        if ssum <= limit:
            l += 1
            r -= 1
        else:
            r -= 1
        ret += 1

    print(ret)
    return ret
            
        
        
    
"""
[조건]
보트 최대 2명탑승 & 무게제한
구명보트 최소 사용 구출

[아이디어]
가장큰놈 + 가장작은놈 같이 타야 가장 가성비 있는 보트 탑승
양끝에 포인터를 두고 움직이면서 크기에 맞는 놈들을 확인

[자료구조]
없음

[로직]
1. 몸무게 정렬
2. 양끝에 포인터를 둔다(l<=r 일때까지)
    2-1. 두포인터의의 값을 합해서 
        - 제한 이내면 ret++, l++,r--
        - 제한 보다 크면 r--
        - 제한 보다 작으면 l++
3. 최종 보트의 수 


"""