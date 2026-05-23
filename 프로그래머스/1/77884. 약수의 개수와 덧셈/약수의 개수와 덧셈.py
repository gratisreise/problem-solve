def iseven(num):
    cnt = 0
    for x in range(1, num+1):
        if x ** 2 > num:
            break
        if num % x == 0:
            if x ** 2 == num:
              cnt += 1
            else: cnt += 2
    return cnt % 2 == 0
        
def solution(left, right):
    return sum(x if iseven(x) else -x for x in range(left, right+1))