import sys
input = sys.stdin.readline

# DP 배열 (최대 N=30까지)
dp = [[0] * 31 for _ in range(31)]

# 재귀로 경우의 수 계산
def go(whole, not_whole):
    if whole == 0 and not_whole == 0:  # 모든 알약 소진
        return 1
    
    #중복되는 경로 제거 == 서로다름을 보장
    ret = dp[whole][not_whole]
    if ret:  # 이미 계산된 경우
        return ret
    
    if whole > 0:  # 1개짜리 먹기
        ret += go(whole - 1, not_whole + 1)
    if not_whole > 0:  # 반 개짜리 먹기
        ret += go(whole, not_whole - 1)
    
    dp[whole][not_whole] = ret
    return ret

# 메인: 여러 테스트 케이스 처리
while True:
    n = int(input())
    if n == 0:  # 0이면 종료
        break
    print(go(n, 0))