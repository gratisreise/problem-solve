def solution(want, number, discount):
    dic = {want[i]: number[i] for i in range(len(want))}
    ret = 0
    for i in range(len(discount) - 9):
        temp = {f:0 for f in discount[i:i+10]}
        for f in discount[i:i+10]:
            if temp[f]:
                temp[f] += 1
            else:
                temp[f] = 1
        if temp == dic: 
            ret += 1
    return ret
    
# 매일 한가지 할인 하나만 구매 가능
# 제품과 수량이 할인하는 날짜와 10일 연속 일치 하는지
# 할인정보에 대해서 반복
# 해당날짜 포함 10개를 묶어 이름 - 수량을 생성한다
# want와 맞는지 확인한다.
# 기대값 1,000,000