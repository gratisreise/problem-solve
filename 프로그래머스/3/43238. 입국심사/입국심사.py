def check(times, mid, n):
    people = 0
    for time in times:
        people += mid // time
        if people >= n: 
            return 1
    return 0

def solution(n, times):
    ret = 0
    left, right = 1, max(times) * n
    
    while left <= right:
        mid = (left + right) // 2
        if check(times, mid, n):
            ret = mid
            right = mid - 1
        else:
            left = mid + 1
            
    return ret

