from collections import defaultdict
def solution(n, results):
    ret = 0
    win, lose = defaultdict(set), defaultdict(set)
    
    for winner, loser in results:
        win[loser].add(winner)
        lose[winner].add(loser)
        
    for i in range(1, n + 1):
        for winner in win[i]:
            lose[winner].update(lose[i])
        for loser in lose[i]:
            win[loser].update(win[i])
    
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n - 1:
            ret += 1
        
    return ret