import sys
import bisect

def main():
    # 전체 입력을 읽고 공백 기준으로 분할
    input = sys.stdin.read
    data = input().split()
    index = 0
    
    # n (배열 크기)와 q (쿼리 개수) 입력 받기
    n = int(data[index])
    q = int(data[index + 1])
    index += 2
    
    # 배열 A 입력 받기
    a = list(map(int, data[index:index + n]))
    index += n
    
    # 각 인덱스에 대한 쿼리 저장 (각 위치에서 (쿼리 ID, x) 튜플 저장)
    qs = [[] for _ in range(n)]
    for i in range(q):
        r = int(data[index]) - 1  # 0 기반 인덱스로 변환
        x = int(data[index + 1])
        index += 2
        qs[r].append((i, x))
    
    # 쿼리 결과를 저장할 배열
    ans = [0] * q
    
    # 증가하는 부분 수열을 추적하는 DP 배열
    dp = [float('inf')] * n
    
    # 배열 A를 순회하며 처리
    for i in range(n):
        # A[i]를 dp 배열의 올바른 위치에 삽입하여 정렬 상태 유지
        pos = bisect.bisect_left(dp, a[i])
        dp[pos] = a[i]
        
        # 현재 위치에 대한 쿼리 처리
        for id, x in qs[i]:
            # x보다 큰 값이 처음 나타나는 위치 찾기
            ans[id] = bisect.bisect_right(dp, x)
    
    # 모든 결과를 출력 (출력 최적화)
    sys.stdout.write('\n'.join(map(str, ans)) + '\n')

if __name__ == "__main__":
    main()


"""
주어진 동적계획법은 최장 증가 부분 수열의 길이를 찾는데 
사용 됩니다.

DP 정의
- dp[j]: 길이가 j인 증가 부분 수열의 마지막 원소 중 최소값
 - 만약 그런 부분 수열이 존재하지 않으면 무한대로 설정

문제 해결 과정
1. 배열 A를 앞에서부터 하나씩 확인하면서 DP 테이블을 업데이트
2. 각 쿼리(R, X)에 대해 정답을 찾기 위해 이진 탐색(binary search)사용

이진 탐색을 활용한 쿼리 처리
- 특정 i = R까지 DP 테이블을 업데이트한 상태에서, dp 배열 중 dp[j] <= X를 만족하는 최대 j 찾기
- 이를 위해 이진 탐색 활용가능
- 매 단계에서, i = R에 도달할 때마다 dp 배열을 이진 탐색하여 답을 계산


"""