def solution(babbling):
    temp = ["aya", "ye", "woo", "ma"]
    ret = 0
    for bab in babbling:
        flag = True
        for word in temp:
            if word*2 in  bab:
                flag = False
                break
        
        if flag:
            for word in temp:
                bab = bab.replace(word, ' ')
            
            bab = bab.replace(' ', '')
            if not bab:
                ret += 1
    return ret
        
        
                
                
                
"""
연속을 어떻게 체크하지??


"""