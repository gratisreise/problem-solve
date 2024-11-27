def check(stones, mid, k):
    temp = 0
    
    for num in stones:
        if num - mid < 0:
            temp += 1
        else:
            temp = 0
        if temp == k:
            return 0
    return 1;
    

def solution(stones, k):
    l, r = 1, int(2e8)
    ret = 0
    while(l <= r):
        mid = (l + r) // 2
        
        if check(stones, mid, k):
            ret = mid
            l = mid + 1
        else:
            r = mid - 1
    return ret

"""
일렬, 숫자, 밟을 때 줄어듬
숫자가 0이되면 밝기 불가 -> 다음 디딤돌로 ㄱㄱ
건너뛰기는 가장 가까운 디딤돌로
왼 -> 오른 
한번에 한명씩 건너기, 하면이 모두 건너고 다음 친구가 건넌다
친구들의 수는 무한

범위: 1 ~ (200억+1)
조건: 0보다 작은 돌 연속되서 k개인지

지금까지 지나간 인원수

200억 이하인 자연수 각 돌들이
체크는 어떻게 하지?
200억 
20만



"""