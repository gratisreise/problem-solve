def solution(myString, pat):
    if len(pat) > len(myString):
        return 0
    
    return sum(1 for i in range(0, len(myString) - len(pat)+1) if myString[i:i+len(pat)] == pat)
        
        