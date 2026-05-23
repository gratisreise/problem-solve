def solution(orders):
    ret = 0
    for order in orders:
        if order.find("cafelatte") != -1:
            ret += 5000
        else: ret += 4500
    return ret
    
# 메뉴만 => 아이스, 아무거나 => 아메리카노