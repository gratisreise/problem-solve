def solution(babbling):
    bbbs = ["aya", "ye", "woo", "ma"]
    ret = 0
    for bb in babbling:
        temp = bb
        for bbb in bbbs:
            temp = temp.replace(bbb, " ")
        temp = temp.replace(" ", "")
        if not temp:
            ret += 1
    return ret 
            
    
"""
발음할 수 있는것 공백으로 변환
공백을 빈문자열로 변환
문자열 있는지 확인하면서 체크

"""