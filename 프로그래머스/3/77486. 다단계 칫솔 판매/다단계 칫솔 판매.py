def calc(name, cost, ret, dict):
    if cost / 10 < 1:
        ret[name] += cost
        return
    ret[name] += (cost - cost//10)
    if cost / 10 < 1 or dict[name] == '-': return
    calc(dict[name], (cost // 10), ret, dict)

def solution(enroll, referral, seller, amount):
    answer = []
    dict = {x:"" for x in enroll}
    
    ret = {x:0 for x in enroll}
    for i in range(len(enroll)):
        dict[enroll[i]] = referral[i]
        
    for i in range(len(seller)):
        calc(seller[i], amount[i]*100, ret, dict)
        
    return [ret[name] for name in enroll]
"""
누가 얼만큼 먹고있니?
내가 판매한 물품 + 가입시킨 판매원의 수익 10%
판매원 이름 enroll
아래에서 위로 올라가는 방향성을 가지고 구현
아래에서 위로 올라가면서 금액을 분배한다
노예 -> 주인 트리 만들기
모든 판매내역에 대해 반복
    트리 탐색하면서 가격분배
    
"""