def solution(signals):
    INF = 32 * 100000
    cnt = []
    for sig in signals:
        temp = [0] * (sum(sig) + 1)
        for i in range(sig[0]+1, sig[0]+sig[1]+1):
            temp[i] = 1
        cnt.append(temp)
    cur = 1
    while cur <= INF:
        st = set()
        for arr in cnt:
            T = (cur-1) % (len(arr)-1)
            st.add(arr[T+1])
            
                
        if cnt == 10: break
        if len(st) == 1 and 1 in st:
            break
        cur += 1
    return cur if cur <= INF else -1
    
"""
[조건]
신호등 n개
초 -> 노 -> 빨
1초부터 시작, 초록부터 시작
정전: 모두 노란불이면 정전
정전이 되는 가장 빠른 시각
모두 노란불 없으면 -1 리턴

[아이디어]
모든시간의 합이 20이하?
각각이 1~18
주기성을 찾아서 리턴하는 식으로 풀어야할듯 
주기성을 가지는 패턴
각각의 패턴을 찾아서 비교해서 찾을 수 있는 방법 없나??
모든 노랑의 시작 부분은 
초록+1인 부분에서 시작 구간은 
주기를 찾아서 어떻게 처리를 해주지?? 
주기를 찾는것도 할 수 있어 시간을 찾는 것도 할 수 있어 다같이 담아서 비교하는건 안된다고 뜨는데 어떻게 해결할 수 있지 힌트를 줘
어떤 시간이 어떤불인지는 해당 시간을 주기로 모듈러 한 다음에 해당 부분이 해당하는 인덱스의 색을 확인하면된다

"""