def solution(common): 
    if (common[1] - common[0]) == (common[2] - common[1]):
        return common[len(common) -1] + (common[1] - common[0])
    elif int(common[1]/common[0]) == int(common[2]/common[1]):
        return common[len(common) -1] * int(common[1]/common[0])
    
        
        