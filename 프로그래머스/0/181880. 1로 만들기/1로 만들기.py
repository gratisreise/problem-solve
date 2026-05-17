def count(n):
    cnt = 0
    while n != 1:
        if n % 2 == 0: 
            n //= 2
        else: n = (n-1) //2
        cnt += 1
    return cnt

def solution(num_list):
    return sum(count(x) for x in num_list)
    