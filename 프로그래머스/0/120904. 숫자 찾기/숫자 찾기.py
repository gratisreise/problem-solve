def solution(num, k):
    num = str(num)
    for i in range(len(num)):
        if int(num[i]) == k: 
            return i+1
    return -1