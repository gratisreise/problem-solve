def solution(n, times):
    answer = 0
    left, right = 1, max(times) * n
    
    while left <= right:
        mid = (left + right) // 2
        people = 0        
        # 이게 왜 가능한 인워수지?
        # 해당 시간에 받을 수 있는 손님의 수
        for time in times:
            people += mid // time
            if people >= n: break
        
        if people >= n:
            answer = mid
            right = mid - 1
            
        elif people < n:
            left = mid + 1
            
    return answer

