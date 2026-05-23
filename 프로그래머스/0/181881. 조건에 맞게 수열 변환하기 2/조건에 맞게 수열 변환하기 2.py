def solution(arr):
    cur = [x for x in arr]
    nextt = [x for x in arr]
    cnt = 0
    while True:
        for i,num in enumerate(nextt):
            if num >= 50 and num % 2 == 0:
                nextt[i] //= 2
            elif num < 50 and num % 2 == 1:
                nextt[i] = num*2+ 1
        if cur == nextt:
            break
        cnt += 1
        cur = [x for x in nextt]
    return cnt
    
    
# a >= 50 and 짝: //2
# a < 50 and 홀: ++
# x번 반복 => arr(x) = arr(x+1)인 x구하기