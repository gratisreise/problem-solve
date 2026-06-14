def solution(bandage, health, attacks):
    ret, prev = health, 0
    cool, sh, ph = bandage
    for att in attacks:
        cur, dam = att
        tum = cur - prev - 1
        ret = min(ret + (tum * sh + (tum // cool)*ph), health)
        ret -= dam
        prev = cur
        if ret <= 0:
            break
    return ret if ret > 0 else -1
        
    
"""
[조건]
t초 감기 x 회복
t초 성공 y 추가 회복
최대체력 제한 있음
피격시 기술 취소, 피격 먼저 처리,
피격시 바로 다시 붕대감기 시작
현재체력이 0이면 체력회복 불가
죽으면 -1, 남은 체력 반환

[아이디어]
공격을 순회하면서 생존하는지 체크

[자료구조]
현재 체력,

[로직]
1. 공격을 순회
    1-1. 이전시간과 현재시간 이전까지 회복량 더해주기
    1-2. 피격 처리
    1-3. 0이 되면 break
2. 남아있는 체력 출력

"""