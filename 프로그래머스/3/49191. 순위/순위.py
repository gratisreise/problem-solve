from collections import defaultdict

def solution(n, results):
    answer = 0
    win, lose = defaultdict(set), defaultdict(set)
    
    for winner, loser in results:
        win[loser].add(winner) # 자신에게 승리한 사람 목록
        lose[winner].add(loser) # 자신에게 패배한 사람 목록
    for i in range(1, n+1):  
        # 나에게 이긴 사람들의
        for winner in win[i]:
            # 승리목록에 나한테 진사람 추가
            lose[winner].update(lose[i])
        # 나에게 진 사람들의
        for loser in lose[i]:
            # 이긴 사람목록에 나에게 이긴 사람들을 추가
            win[loser].update(win[i])
    
    # 모든 기록에서
    for i in range(1, n+1):
        # 합이 n-1이면 ++
        if len(win[i]) + len(lose[i]) == n-1:
            answer += 1

    return answer

