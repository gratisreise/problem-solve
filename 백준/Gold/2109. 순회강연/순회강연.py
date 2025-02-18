import sys
import heapq

def main():
    input = sys.stdin.read
    data = input().split()  
    
    n = int(data[0])
    v = []
    index = 1
    
    # 입력 처리 및 (b, a) 저장
    for i in range(n):
        a, b = int(data[index]), int(data[index + 1])
        v.append((b, a))
        index += 2
    
    # b 기준 정렬
    v.sort()
    
    pq = []  # 최소 힙
    
    for b, a in v:
        heapq.heappush(pq, a)
        if len(pq) > b:
            heapq.heappop(pq)
    
    # 우선순위 큐에 남아있는 값의 합 계산
    ret = sum(pq)
    
    sys.stdout.write(str(ret) + '\n')

if __name__ == "__main__":
    main()
