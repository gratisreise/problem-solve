def solution(prices):
    size = len(prices)
    answer = [0] * size
    for i in range(size):
        cnt = 0
        for j in range(i+1, size):
            cnt += 1
            if prices[i] <= prices[j]: answer[i] += 1
            else:
                answer[i] += 1
                break
        print(cnt)
    return answer


