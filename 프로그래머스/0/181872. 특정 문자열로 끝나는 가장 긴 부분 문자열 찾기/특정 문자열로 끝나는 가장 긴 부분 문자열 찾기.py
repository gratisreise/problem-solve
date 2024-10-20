def solution(myString, pat): 
    return myString[0:max( i for i in range(len(myString)-len(pat)+1) if myString[i:i+len(pat)] == pat)+len(pat)]